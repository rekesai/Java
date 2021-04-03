import java.util.Scanner;

public class Test2 {
    
    //求数字n的二进制中1的个数
    /*public static int binNumOfOne2(int n){
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    public static int binNumOfOne1(int n){
        int count = 0;
        for(int i = 0; i < 32; i++){
            if(((n >>> i) & 1)!= 0){
                count++;
            }
        }
        return count;
    }
    public static int binNumOfOne(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(binNumOfOne2(scanner.nextInt()));
    }*/

    /*public static void game(){
        int count = 3;
        while(count != 0){
            count--;
            Scanner scanner = new Scanner(System.in);
            String password = scanner.nextLine();
            if(password.equals("1234")){
                System.out.println("输入成功！");
                break;
            }
            else{
                System.out.println("输入错误，还有" + count + "次机会！");
            }
        }
    }
    public static void main(String[] args) {
        game();
    }*/


    //1/1 - 1/2 + 1/3 -......+ 1/99 - 1/100
    /*public static void main(String[] args) {
        int flg = 1;
        double sum = 0;
        for(int i = 1; i <= 100; i++){
            sum += flg * (1.0/i);
            flg = -flg;
        }
        System.out.println(sum);
    }*/

    /*public static int gcd(int a, int b){
        int c = a % b;
        while(c != 0){
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数字a:");
        int a = scanner.nextInt();
        System.out.print("请输入数字b:");
        int b = scanner.nextInt();
        System.out.println("最大公约数为：" + gcd(a, b));
    }*/


    /*public static int add(int x, int y){
        return x + y;
    }
    public static double add(double x, double y){
        return x + y;
    }

    public static void main(String[] args) {
        int ret = add(3, 5);
        System.out.println(ret);
        double ret2 = add(3.4, 2.5);
        System.out.println(ret2);
    }*/
}
