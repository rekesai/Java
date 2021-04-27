import java.util.Scanner;
public class Recursion {



    //输入一个字符串，将其中重复的字符串删除并按照原来的顺序打印出来
    public static void removeRepeat(String[] args) {
        String str = "aaabbccccccccc";
        //先转换成字符数组
        char[] chars = str.toCharArray();
        //用两个循环来找出后面和前面重复的字符并把它变成空格“ ”
        for(int i = 0; i < chars.length; i++){
            for(int j = i+1; j < chars.length; j++){
                if(chars[i] == chars[j]){
                    chars[j] = ' ';
                }
            }
        }
        //把字符数组变成字符串
        String ret = new String(chars);
        //用字符串的方法replace将原来的空格“ ”，变成什么都没有“”，并输出
        System.out.println(ret.replace(" ", ""));
    }


    //青蛙跳台阶问题
    public static int jumpFloor(int n){
        if(n == 1 || n == 2){
            return n;
        }
        return jumpFloor(n-1) + jumpFloor(n-2);
    }

    //递归求解汉诺塔问题
    public static void move(char pos1,char pos2){
        System.out.print(pos1 + "=>" + pos2 + " ");
    }
    public static void hanoi(int n, char pos1, char pos2, char pos3){
        if(n == 1){
            move(pos1, pos3);
        }
        else{
            hanoi(n-1, pos1, pos3, pos2);
            move(pos1, pos3);
            hanoi(n-1, pos2, pos1, pos3);
        }
    }

    //递归求 N 的阶乘
    public static int everyMul(int n){
        if(n != 1){
            return  n * everyMul(n-1);
        }
        return 1;
    }

    //递归求 1 + 2 + 3 + ... + 10
    public static int sum(int n){
        if(n != 1){
            return  n + sum(n-1);
        }
        return 1;
    }

    //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
    public static void eveNumber(int n){
        if(n/10 != 0){
            eveNumber(n/10);
        }
        System.out.print(n%10 + " ");
    }


    //写一个递归方法，输入一个非负整数，返回组成它的数字之和
    public static int number(int num){
        if(num/10 != 0){
            return  number(num/10) + number(num%10);
        }
        return num;
    }
    //1,1,2,3,5,8,13,21,34,55
    public static int fibonacci(int n){

        if(n > 2){
            return fibonacci(n-1)+fibonacci(n-2);
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println(fibonacci(sc.nextInt()));
        //System.out.println(number(sc.nextInt()));
        //eveNumber(sc.nextInt());
        //System.out.println(sum(sc.nextInt()));
        //System.out.println(everyMul(sc.nextInt()));
        //hanoi(1,'A', 'B', 'C');
        //System.out.println();
        //hanoi(2,'A', 'B', 'C');
        //System.out.println();
        //hanoi(3,'A', 'B', 'C');
        System.out.println(jumpFloor(1));
        System.out.println(jumpFloor(2));
        System.out.println(jumpFloor(3));
        System.out.println(jumpFloor(4));
    }


}
