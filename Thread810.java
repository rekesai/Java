public class Thread810 {
    // 饿汉模式 - 实例的创建出现在”类加载“阶段，第一次使用到这个类的时候就会把这个类的.class加载到内存里
    static class Singleton {
        // 期望Singleton是一个单例类，只有一个实例
        // 创建唯一个的一个Singleton实例保存起来
        private static Singleton instance = new Singleton();
        // 在提供一个方法，来获取到这个实例
        public static Singleton getInstance(){
            return instance;
        }
        // 再将类的构造方法设为private防止其他代码创建实例
        private Singleton(){}
    }
    static class Singleton2 {
        // 懒汉模式 - 创建实例的时机是在第一次使用到 getInstance 的时候
        volatile private static Singleton2 instance = null;
        public static Singleton2 getInstance() {
            if(instance == null){
                synchronized(Singleton2.class){
                    if(instance == null){
                        instance = new Singleton2();
                    }
                }
            }
            return instance;
        }
        private Singleton2(){}
    }
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
    }
}
