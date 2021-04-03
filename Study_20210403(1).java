import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要判断的数字：");
        int n = scanner.nextInt();
        int i = 0;
        for(i = 2; i < n; i++){
            if(n % i == 0){
                System.out.println(n + "是合数");
                break;
            }
        }
        if(n == i){
            System.out.println(n + "是素数");
        }
    }

    /*public static void main(String[] args) {
        //猜数字游戏
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int ranNum = random.nextInt(100);
        while(true){
            System.out.print("请输入你要猜的数字：");
            int num = scanner.nextInt();
            if(num < ranNum){
                System.out.println("小了！");
            }
            else if(num > ranNum){
                System.out.println("大了！");
            }
            else{
                System.out.println("猜对了！");
                break;
            }
        }
    }*/

    /*public static void main(String[] args) {
        //字符串和数字同时输入时，先输入字符串，不然可能录不进去
        Scanner scanner = new Scanner(System.in);
        System.out.print("姓名：");
        String name = scanner.nextLine();
        System.out.println(name);
        System.out.print("年龄：");
        int age = scanner.nextInt();
        System.out.println(age);
        System.out.print("价格：");
        double price = scanner.nextDouble();
        System.out.println(price);
    }*/


    /*public static void main(String[] args) {
        int i = 2;
        *//*while(i > 0){
            System.out.println(i);
            i--;
        }*//*
        do{
            System.out.println(i);
            i--;
        }while(i > 0);
    }*/

   /*public static void main(String[] args) {
        //找到1-100之间既能被3整除也能被5整除的数字
        *//*int i = 1;
        while(i <= 100){
            if(i%3==0 && i%5==0){
                System.out.println(i);
            }
            i++;
        }*//*
        *//*int i = 1;
        while(i <= 100){
            if(i % 15 != 0){
                i++;
                continue;
            }
            System.out.println(i + "是3和5的倍数");
            i++;
        }*//*
    }*/

    /**不能做switch参数的数据类型
     * long  float double  boolean 字符串都可以  枚举也可以作为参数
     */
    /*public static void main(String[] args) {
        int i = 1;
        switch (i){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
            default:
                System.out.println("输入错误");
                break;
        }
    }*/
//while的参数必须是boolean表达式，不能像c一样放个数字，比如放1让它无限循环，遇到0退出
    /*public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        while(i <= 100){
            sum += i;
            i += 2;
        }
        System.out.println(sum);
    }*/

    /*public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        while(i <= 100){
            sum += i;
            i++;
        }
        System.out.println(sum);
        i = 1;
        int sumOdd = 0;
        while(i <= 100){
            sumOdd += i;
            i += 2;
        }
        System.out.println(sumOdd);
        i = 2;
        int sumEve = 0;
        while(i <= 100){
            sumEve += i;
            i += 2;
        }
        System.out.println(sumEve);
    }*/

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(Scanner){
            int fac = 1;
            int i = 1;
            int num = 0;
        }
    }*/

    /*public static void main(String[] args) {
        //1！+2！+3!+4!+5! = 153;
        Scanner scanner = new Scanner(System.in);//输入必需代码
        int n = scanner.nextInt();
        int num = 1;
        int sum = 0;
        while(num <= n){
            int i = 1;
            int fac = 1;
            while(i <= num){
                fac *= i;
                i++;
            }
            sum += fac;
            num++;
        }
        System.out.println(sum);
    }*/
}
