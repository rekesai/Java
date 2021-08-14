import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {
    public static void main(String[] args) {
        // 通过 Executors 的静态方法来负责创建不同类型的线程池
        // 创建一个包含10个线程的线程池
        ExecutorService pool1 = Executors.newFixedThreadPool(10);
        // 创建一个线程数量动态变化的线程池
        ExecutorService pool2 = Executors.newCachedThreadPool();

        // 创建好了需要往里面放任务
        for (int i = 0; i < 10; i++){
            pool1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello");
                }
            });
        }
    }
}
