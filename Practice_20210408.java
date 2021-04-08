import java.util.Random;
import java.util.Scanner;
public class Practice {

    public static void main(String[] args){
        //leapYear();//输出 1000 - 2000 之间所有的闰年
        //primeNumber();//打印 1 - 100 之间所有的素数
        Scanner scanner = new Scanner(System.in);
        //int num = scanner.nextInt();
        //primeNumber(num);//输入一个数字判断其是不是素数
        /*while(scanner.hasNextInt()){
            int age = scanner.nextInt();
            age(age);
        }*/
        /*while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            xline(n);
        }*/
        guessNumber();

    }

    //猜数字游戏
    public static void guessNumber(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int ranNum = random.nextInt(100);
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            if(num > ranNum) {
                System.out.println("猜大啦！");
            }
            else if(num < ranNum){
                System.out.println("猜小啦！");
                else{
                    System.out.println("猜对啦！");
                }
            }
        }
    }


    //打印 X 字母
    public static void xline(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(j == i || j == (n-i+1)){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    //根据输入的年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
    public static void age(int age){
        if(0 <= age && age <= 18){
            System.out.println("当前年龄的人是少年");
        }
        else if(19 <= age && age <= 28){
            System.out.println("当前年龄的人是青年");
        }
        else if(29 <= age && age <= 55){
            System.out.println("当前年龄的人是中年");
        }
        else if(56 <= age){
            System.out.println("当前年龄的人是老年");
        }
        else{
            System.out.println("输入错误");
        }
    }


    //输入一个数字判断其是不是素数
    //重载是同方法名不同参数返回值无所谓
    public static void primeNumber(int num){
        int n = 0;
        if(num == 1){
            System.out.println(num + "既不是素数也不是合数");
        }
        else{
            //Math.sqrt(num)-给num开方 当一个数是合数时，必然有一个乘数小于他的开方
            for(n = 2; n <= Math.sqrt(num); n++){
                if(num%n == 0){
                    System.out.println(num + "不是素数");
                    break;
                }
            }
            if(n > Math.sqrt(num)){
                System.out.println(num + "是素数");
            }
        }
    }


    //打印 1 - 100 之间所有的素数
    public static void primeNumber(){
        int num = 0;
        int n = 0;
        for( num = 2; num <= 100; num++){
            //Math.sqrt(num)-给num开方 当一个数是合数时，必然有一个乘数小于他的开方
            for( n = 2; n <= Math.sqrt(num); n++){
                if(num%n == 0){
                    break;
                }
            }
            if(n > Math.sqrt(num)){
                System.out.println(num + "是素数");
            }
        }
    }


    //输出 1000 - 2000 之间所有的闰年
    //闰年规则：可以整除4且不能整除100，或者整除400
    public static void leapYear(){
        for(int year = 1000; year <= 2000; year++){
            if((year%4 == 0 && year%100 != 0) || year%400 == 0){
                System.out.println(year + "是闰年");
            }
        }
    }
}
