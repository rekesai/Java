import javafx.scene.SceneAntialiasing;
import java.util.Arrays;
import java.util.Scanner;

public class Practice {

    public static void main(String[] args){
        //有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
        /*int[] array = {1,1,2,2,3,3,4,4,5};
        findOnly(array);*/

        //求斐波那契数列的第n项。(迭代实现)
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacci(n));*/

        //求1！+2！+3！+4！+........+n!的和
        //factorialSum();

        //求 N 的阶乘
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(factorial(n));*/

        //调整数组顺序使得奇数位于偶数之前,调整之后，不关心大小顺序
        /*int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        oddBeforeEven(array);*/

        //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
        sum(1,2);
        sum(1.2,3.6,4.67);
    }


    //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
    //重载即方法名相同，参数不同，返回值无所谓的方法
    public static void sum(int x, int y){
        System.out.println(x + y);
    }
    public static void sum(double x, double y, double z){
        System.out.println(x + y + z);
    }


    //调整数组顺序使得奇数位于偶数之前,调整之后，不关心大小顺序
    //首先判断array[left]是否为偶数，若为偶数进入事件
    //其次判断array[right]是否为奇数，若为奇数进入事件交换left和right的值
    //出if语句时right无非为两种情况1.right为奇数，与left交换  2.right为偶数，right--
    //再出if语句需要判断left是否为奇数，若为奇数再++
    public static void oddBeforeEven(int[] array){
        int left = 0;
        int right = array.length-1;
        while(left < right){
            if(array[left]%2 == 0){
                if(array[right]%2 != 0){
                    int tmp = array[left];
                    array[left] = array[right];
                    array[right] = tmp;
                }
                right--;
            }
            if(array[left]%2 != 0){//避免出现left是偶数，right也是偶数，出来后left++的情况，加个判断
                left++;
            }
        }
        System.out.println(Arrays.toString(array));
    }


    //求1！+2！+3！+4！+........+n!的和
    //1,2,6,24,120,720
    //1,3,9,33,153
    public static void factorialSum(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += factorial(i);
        }
        System.out.println(sum);
    }


    //求 N 的阶乘
    //1,2,6,24,120,720
    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        else {
            return n * factorial(n-1);
        }
    }


    //求斐波那契数列的第n项。(迭代实现)
    // 1,1,2,3,5,8,13,21,34,55,89
    public static int fibonacci(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }


    //有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
    //相同的数字异或一次之后变成0，将所有数字异或一次就能得出单独的数字
    public static void findOnly(int[] array){
        int num = 0;
        for(int i = 0; i < array.length; i++){
            num ^= array[i];
        }
        System.out.println(num);
    }

}
