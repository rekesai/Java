import java.util.concurrent.TransferQueue;

public class ThreadBlockingQueue {
    // 基于数组实现一个普通队列
    // 再改进成阻塞队列
    static class BlockingQueue{
        private int[] items = new int[1000];
        // 约定 [head tail) 是一个左闭右开区间
        // 从 head 处取元素
        private int head = 0;
        // 从 tail 处添加元素
        private int tail = 0;
        // 表示队列中的元素个数
        private int size = 0;
        // 引入锁对象
        private Object locker = new Object();

        // 入队列
        public void put(int value) throws InterruptedException {
            synchronized (locker){
                // 如果队列满了，阻塞等待，等待队列不为空的时候，再去进行插入
                while (size == items.length){
                    locker.wait();
                }
                // 队列没满，插入到tail
                items[tail] = value;
                tail++;
                if (tail >= items.length){
                    tail = 0;
                }
                size++;
                locker.notifyAll();
            }
        }
        // 出队列
        public Integer take() throws InterruptedException {
            int ret = 0;
            synchronized (locker){
                // 队列为空也要阻塞队列
                while (size == 0) {
                    locker.wait();
                }
                ret = items[head];
                head++;
                if (head >= items.length){
                    head = 0;
                }
                size--;
                locker.notifyAll();
            }
            return ret;

        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new BlockingQueue();
        Thread producer = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    try {
                        System.out.println("生产了元素：" + i);
                        queue.put(i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread customer = new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        int ret = queue.take();
                        System.out.println("消费了元素：" + ret);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();
        customer.start();
        producer.join();
        customer.join();
    }
}