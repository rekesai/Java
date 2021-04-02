public class Test {
    public static void main1(String[] args) {
        short a = 128;
        byte b = (byte)a;
        System.out.println(a);
        System.out.println(b);
    }

    public static void main2(String[] args) {
        double d = 2.0;
        int i = 5;
        d /= i++;
        System.out.println(d);
    }

    public static void main3(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("交换前a：" + a);
        System.out.println("交换前b：" + b);
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("交换后a：" + a);
        System.out.println("交换后b：" + b);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("交换前a = " + a);
        System.out.println("交换前b = " + b);
        a = a ^ b;
        /**    0000 1010
         *     0001 0100
         * a = 0001 1110
         */
        b = a ^ b;
        /**    0001 1110
         *     0001 0100
         * b = 0000 1010
         */
        a = a ^ b;
        /**    0001 1110
         *     0000 1010
         * a = 0001 0100
         */
        System.out.println("交换后a = " + a);
        System.out.println("交换后b = " + b);
    }

}
