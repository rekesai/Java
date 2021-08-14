import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    static class ThreadPool{
        // 1.先描述一个任务，直接使用Runnable，不需要额外的类
        // 2.使用阻塞队列来组织若干个任务
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        // 3.描述一个线程，用来进行工作
        static class Worker extends Thread{
            private BlockingQueue<Runnable> queue = null;
            public Worker(BlockingQueue<Runnable> queue){
                this.queue = queue;
            }
            @Override
            public void run() {
                while (true) {
                    try {
                        Runnable runnable = queue.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        // 4.把这个线程组织起来
        private List<Worker> workers = new ArrayList<>();

        // 设定线程池最大数量
        private static final int MAX_WORKERS_COUNT = 10;
        // 核心接口execute
        public void execute(Runnable command){
            try {
                if(workers.size() < MAX_WORKERS_COUNT){
                    // 当线程池中没有足够的线程时就创建一个新的线程
                    Worker worker = new Worker(queue);
                    worker.start();
                    workers.add(worker);
                }
                queue.put(command);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello");
                }
            });
        }
    }
}