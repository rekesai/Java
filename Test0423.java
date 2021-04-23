import java.util.Scanner;

public class Test0423 {


    /*
    输入描述:输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。接下来t行, 每行一组数据。
    每行的第一个整数为整数的个数n(1 <= n <= 100)。
    接下来n个正整数, 即需要求和的每个正整数。
    输出描述:每组数据输出求和的结果

    输入例子1:
    2
    4 1 2 3 4
    5 1 2 3 4 5
    输出例子1:
    10
    15
    * */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
    /*
    输入描述：输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入
    输出描述：输出a+b的结果
    输入例子1:    1 5
                10 20
                0 0
    输出例子1: 6
             30
    */
    public static void main4(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a==0 && b==0){
                return;
            }
            System.out.println(a+b);
        }
    }


    /*
    输入数据包括多组。每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。接下来n个正整数,即需要求和的每个正整数。
    输入示例 4 1 2 3 4               输出示例   10
            5 1 2 3 4 5                      15
            0
    * */
    public static void main3(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            if(n == 0){
                return;
            }
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }

    public static void main2(String[] args) {
        String str1 = "he"+"llo";
        String str2 = new String(str1);//new了一个新的对象
        if(str1.equals(str2)){
            System.out.println(".equals succeed");
        }
        if(str1 == str2){
            System.out.println("==succeed");
        }
        System.out.println(str1.substring(1, 3));//输出el，左闭右开区间

    }

    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";//false
    }
    public static void main1(String[] args) {
        System.out.println(isAdmin("Admin"));
    }
}
