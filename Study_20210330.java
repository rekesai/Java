import java.sql.PseudoColumnUsage;

/**文档注释
 * psvm-写一个main函数
 * sout-System.out.println();
 */

/*块注释-快捷键ctrl+shift+/ */

public class TestDemo {

    public static void main1(String[] args) {
        int a = 10;
        System.out.println(a);
        int b = 20;
        System.out.println(b);
        System.out.println("a:" +a+ " b:" +b);//字符串拼接任何变量都会变成字符串，此时的+是拼接的意思
        System.out.println("a" +a+b+ "b");
        System.out.println(a+b+ "a" + "b");//如果首先出现的不是字符串，那么是要先运算的
        System.out.println("hello world!");
    }

    public static void main2(String[] args) {
        int a = Integer.MAX_VALUE;//2147483647   Integer.  是int的包装类
        System.out.println(a);
        int b = Integer.MIN_VALUE;//-2147483648
        System.out.println(b);
        System.out.println(a+1);//-2147483648
        System.out.println(b-1);//2147483647
    }

    public static void main3(String[] args) {
        double d = 12.5;//8个字节
        System.out.println(d);
        int a = 1;//4个字节
        int b = 2;
        System.out.println(a/b);
        //float f1 = 12.5;//这里的12.5默认为double类型，Java是强类型语言，对数据的类型的要求很严格，所以也很安全
        float f2 = 12.5f;//在数字后加上f转化为float就可以了
    }

    public static void main4(String[] args) {
        byte b1 = 10;//1个字节  8位
        //byte b1 = 128;//赋值时不可以超出该类型的范围
        System.out.println(Byte.MAX_VALUE);// -128~127
        System.out.println(Byte.MIN_VALUE);
        byte b2 = 20;
        //b2 = b1 + b2;//计算时将b1和b2转换成int类型，但是b2是字节类型，将两个int赋值给byte时可能会有损失
        b2 = 10 + 20;//这里能通过是因为10和20是常量，编译的时候就被替换成了30,
        byte b3 = 10 + 20;
    }

    public static void main5(String[] args) {
        //java中boolean类型只有true和false，没有其他值
        boolean flag = true;
        boolean flag1 = false;
        char ch = 123;//char在java中是2个字节
        String str1 = "zxc ";
        System.out.println(str1);//str.sout+回车
        String str2 = "is ";
        String str3 = "cool!";
        String str4 = str1+str2+str3;
        System.out.println(str4);
    }

    public static void main6(String[] args) {
        int a = 10;
        {
            a = 20;//这个a和外面的a是一个a
            int b = 1;
        }
        //b = 2;//这个b和里面的b不是一个b
    }

    public static void main7(String[] args) {
        int maxNun = 10;//变量名采用小驼峰方式命名，当一个变量名由多个字母组成的时候，中间的单词首写字母大写
        int a_1 = 20;//以字母、数字、下划线、美元符$组成，不能用数字开头
        int a_2 = 30;//命名时尽量使用名词，见词思意，不要用拼音
        int a$3 = 10;//不建议美元符
        int ______________ = 2;//合法不合理，只有下划线太离谱了
    }

    public static void main(String[] args) {
        int a;
        //System.out.println(a);//局部变量在使用时一定要初始化，不然报错
        int b = 10;
        b = 20;
        final int c = 1;//常量只能初始化一次
        //c = 2;
    }
}
