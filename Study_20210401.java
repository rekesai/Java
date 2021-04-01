public class Test {
    public static void main1(String[] args){
        int i = 2;
        System.out.println(i);//2
        {
            i = 1;
            System.out.println(i);//1
        }
        System.out.println(i);//1
        //只要是字符串和其他类型的数据使用+号进行拼接的时候，字符串在前就变成字符串，算数在前就先算再拼接
        System.out.println("zxc" + i);//zxc1
        System.out.println(i+1 + "zxc");//2zxc
    }

    public static void main2(String[] args) {
        //常量是在程序运行的过程中不可修改的
        final int i = 10;
        //i = 20;
        final int a;
        //System.out.println(a);//未初始化的常量或者变量都是不可打印的
        String str = "league of legends";
        System.out.println(str);
        System.out.println("My name is \"德莱厄斯\".");//   \转义字符可以用来打印特殊的字符 比如\n是换行  \t是水平制表符，就是table键
    }

    public static void main3(String[] args) {
        //字符串转换成整形
        String str = "10a";
        System.out.println(str);
        int ret = Integer.parseInt(str);//不能转换10a
        System.out.println(ret);
        int ret2 = Integer.valueOf(str);//可以转换10a
        System.out.println(ret2);
    }

    public static void main4(String[] args) {
        System.out.println(5 / 2);//2
        System.out.println((float)5 / 2);//2.5
        System.out.println(5 / (float)2);//2.5
        System.out.println((float)(5/2));//2.0
    }

    public static void main5(String[] args) {
        System.out.println(10%3);//1
        System.out.println(10%-3);//1
        System.out.println(-10%3);//-1
        System.out.println(-10%-3);//-1
        System.out.println(11.5%2);//1.5
    }

    public static void main6(String[] args) {
        int a = 10;
        byte b = 20;
        //byte b = a +10;
        b += a;// +=可以强行转换数据类型

    }

    public static void main7(String[] args) {
        int a = 10;
        a = a++;
        System.out.println(a);//10
    }

    public static void main8(String[] args) {
        byte b = (byte)(Byte.MAX_VALUE + 1);
        System.out.println(b);
        short sh = (short)(Short.MAX_VALUE + 1);
        System.out.println(sh);
        int i = Integer.MAX_VALUE + 1;
        System.out.println(i);
    }

    public static void main9(String[] args) {
        int a = 1;
        int b = 2;
        //布尔表达式
        System.out.println(a == b);//false
        System.out.println(a != b);//true
        System.out.println(a > b);//false
        System.out.println(a < b);//true
        System.out.println(a>0 && b>10);//false逻辑与一假则假
        System.out.println(a>0 || b>10);//true逻辑或一真则真
        System.out.println(!true);//false

    }

    public static void main10(String[] args) {
        //短路求值   0不能作为除数，会报错
        System.out.println(1>2 && 1/0 == 0);//false   逻辑与一假则假，前假则假，不执行后面的表达式
        /*System.out.println(1<2 && 1/0 == 0);//报错     前真判断后面表达式，报错
        System.out.println(1>2 || 1/0 == 0);//报错     逻辑或一真则真，前假判断后者，报错*/
        System.out.println(1<2 || 1/0 == 0);//true    前真则真，不执行后面表达式
    }

/**
 * 左移<<，给右边补0，移几位相当于给原数字*2^几次方
 * 右移>>，给左边补符号位，移几位相当于给原数字/2^几次方
 * 无符号右移  >>>，无论符号位是什么都补0，没有无符号左移
 * &按位与，遇0则0  0101 0101
 *                1111 1111
 *                0101 0101
 * |按位或，遇1则1  0101 0101
 *                0000 0000
 *                0101 0101
 * ~按位取反       0000 0000
 *               1111 1111
 * ^按位异或，相同则0，不同则1
 * 1 2 3 3 2 1 4 找出单身狗，用异或，相同的数字异或变成0，将所有的数字异或一下相当于0和4异或，答案就出来了
 * 1 2 3 3 2 1 4 5 找出单身狗，用异或，将所有的数字异或一下，答案相当于4和5异或了一下，从得出的这个数字从右向左数
 * 碰到1，则是两个数字不同的地方，将所有的数字按照这个位置有无1来划分成两个部分
 * 再在这两个部分分别异或，就能找出这两个单身狗
*/
    public static void main11(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;
        a = a^b;
        /**    0000 1010
         *     0001 0100
         * a = 0001 1110
         */
        b = a^b;
        /**    0001 1110
         *     0001 0100
         * b = 0000 1010
         */
        a = a^b;
        /**    0001 1110
         *     0000 1010
         * a = 0001 0100
         */
        System.out.println(a);
        System.out.println(b);
        int maxNum  = c > (a > b ? a : b) ? c : (a > b ? a : b);
        System.out.println(maxNum);
    }

    public static void main12(String[] args) {
        int i = 10;
        if(i > 9){
            System.out.println("i大于9");
        }
        else{
            System.out.println("i不大于9");
        }
    }
}
