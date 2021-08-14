import java.util.concurrent.PriorityBlockingQueue;

public class ThreadTimer {
    // 每个 Task 实例包含一个具体的要执行的任务
    // Task 要放到一个优先队列，但是优先队列里需要进行“比较优先级”
    static class Task implements Comparable<Task>{
        // 啥时候执行
        private long time;
        // 执行啥
        private Runnable command;
        // 一般设定定时器的时候，传入的时间都是一个时间间隔
        public Task(Runnable command, long time){
            this.command = command;
            // 为了后面方便判定，在这里记录绝对时间
            this.time = System.currentTimeMillis() + time;
        }
        public void run(){
            command.run();
        }
        @Override
        public int compareTo(Task o) {
            // 时间较小的排在前面
            return (int)(this.time-o.time);
        }
    }

    static class Timer{
        // 创建一个带优先级的阻塞队列
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        // 使用这个对象完成线程之间的协调
        private Object mailBox = new Object();
        public void schedule(Runnable command, long after){
            Task task = new Task(command, after);
            queue.put(task);
            // 当worker 线程中包含wait机制的时候,在安排任务的时候就需要显式的唤醒一下
            // 此处是为了处理 插入的新任务比队首的任务还靠前的情况，就要唤醒线程来重新判断是否需要等待和计算等待多久
            synchronized (mailBox){
                mailBox.notify();
            }
        }
        public Timer(){
            // 创建一个线程，让这个线程去扫描队首元素，看他能不能执行
            Thread worker = new Thread(){
                @Override
                public void run() {
                    while(true){
                        // 取出队首元素，看看能不能执行
                        try {
                            Task task = queue.take();
                            long currentTime = System.currentTimeMillis();
                            if(task.time <= currentTime){
                                // 时间到了执行任务
                                task.run();
                            }
                            else{
                                queue.put(task);
                                synchronized (mailBox){
                                    mailBox.wait(task.time-currentTime);
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            worker.start();
        }
    }
    public static void main(String[] args) {
        Timer timer = new Timer();
        Runnable command = new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到了！");
                timer.schedule(this, 3000);
            }
        };
        System.out.println("安排任务了！");
        timer.schedule(command, 3000);
    }
}