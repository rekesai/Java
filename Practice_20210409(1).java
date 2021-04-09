import java.util.Random;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args){
        //guessNumber();//猜数字游戏
        //narcissisticNumber();//求水仙花数
        //sum(100);//计算 1/1 - 1/2 + 1/3 - 1/4 + 1/5 …… + 1/99 - 1/100 的值
        //greatestCommonDivisor();//求两个正整数的最大公约数
        //findOne();//求一个整数，在内存当中存储时，二进制1的个数
        //getBinarySequence();//获取一个数二进制序列中所有的奇数位和偶数位，分别输出二进制序列
        //inputPassword();//编写代码模拟三次密码输入的场景
        //Scanner scanner = new Scanner(System.in);
        //int num = scanner.nextInt();
        //digitOfNumber(num);//输出一个整数的每一位，如：123的每一位是1 ， 2 ， 3
        //multiplicationFormulaTable();//输出n*n的乘法口诀表，n由用户输入
    }


    //输出n*n的乘法口诀表，n由用户输入。
    public static void multiplicationFormulaTable(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(i+"*"+j+"="+i*j+'\t');
            }
            System.out.println();
        }
    }



    //输出一个整数的每一位，如：123的每一位是1 ， 2 ， 3
    public static void digitOfNumber(int num){
        if(num > 9){
            digitOfNumber(num/10);
        }
        System.out.print(num%10 + " ");
    }


    //编写代码模拟三次密码输入的场景
    //最多能输入三次密码，密码正确，提示“登录成功”
    //密码错误可以重新输入，最多输入三次。三次均错，则提示退出程序
    public static void inputPassword(){
        String password = "123456";
        int count = 3; //增加一个计数器，用来输出在机会用光且没有输入正确密码时的事件
        for(int i = 3; i > 0; i--){
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            count--; //每输入一次count-1，对应下面count次机会，当count=0时，且没有输入正确密码，触发count=0时的事件
            if(password.compareTo(str) == 0){
                //判断字符串之间的Union值，前者大则返回一个大于1的值，后者大则返回一个小于1的值，相同则返回0
                System.out.println("登录成功！");
                break;//登录成功则立即退出循环，结束程序
            }
            else if(count == 0){
                System.out.println("机会用光了，退出程序！");
            }
            else{
                System.out.println("密码错误，还有"+ count +"次机会");
            }
        }
    }


    //获取一个数的二进制序列中所有的奇数位和偶数位，分别输出二进制序列
    /*
    15
      0000 1111
    & 1111 1111
      0000 1111
    偶数序列0011
    奇数序列0011
    00000000 00000000 00000000 00001111
    * */
    public static void getBinarySequence(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.print("奇数位为：");
        for(int i = 30; i > -1; i -= 2){
            //从第31位开始与运算，逐级递减2，最后一位为0了，所以要大于-1
            int tmp = (num>>i)&1;
            System.out.print(tmp);
        }
        System.out.print('\n'+"偶数位为：");
        for(int i = 31; i > 0; i -= 2){
            //从第32位开始与运算，逐级递减2，最后一位为1了，所以要大于0
            int tmp = (num>>i)&1;
            System.out.print(tmp);
        }
    }


    //求一个整数，在内存当中存储时，二进制1的个数。
    public static void findOne(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        while(num != 0){
            count ++;
            num = num >>> 1;
        }
        System.out.println("二进制1的个数为" + count);
    }


    //求两个正整数的最大公约数
    /*
    18  24
    18%24=18
    24%18=6
    18%6=0
    * */
    public static void greatestCommonDivisor(){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int a = x;
        int b = y;
        while(a % b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        System.out.println(x + "和" + y + "的最大公约数是" + b);
    }


    //计算 1/1 - 1/2 + 1/3 - 1/4 + 1/5 …… + 1/99 - 1/100 的值 。
    public static void sum(int n){
        int flag = 1;
        double sum = 0;
        for (int i = 1; i <= n ; i++) {
            sum = sum + flag*(1.0/i);
            flag = -flag;
        }
        System.out.println(sum);
    }


    //求出0～999之间的所有“水仙花数”并输出。Narcissistic number
    // (“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本 身，如；153＝1*1*1＋5*5*5＋3*3*3?，则153是一个“水仙花数“。）
    public static void narcissisticNumber(){
        for (int i = 0; i < 1000 ; i++) {
            if(i/100 > 0){
                int x = i/100;//获取百位
                int y = (i%100)/10;//获取十位
                int z = i%10;//获取个位
                if(x*x*x+y*y*y+z*z*z == i){
                    System.out.println(i+"是水仙花数");
                }
            }
        }
    }


    //完成猜数字游戏 ，用户输入数字，判断该数字是大于，小于，还是等于随机生成的数字，等于的时候退出程序。
    public static void guessNumber(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();//这里的小括号中可以给数字可以不给，给的话就是以这个数字为起点开始给一个随机数
        int ranNum = random.nextInt(100);//这里的小括号中的数字决定了随机数的区间，[0,100)
        while(true){
            int num = scanner.nextInt();
            if(num > ranNum){
                System.out.println("猜大啦！");
            }
            else if(num < ranNum){
                System.out.println("猜小啦！");
            }
            else{
                System.out.println("猜对啦！就是"+ranNum);
                break;
            }
        }
    }

}
