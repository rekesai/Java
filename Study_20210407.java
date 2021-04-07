import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Test {

    //1,2,3,4,5,6 将奇数放在偶数的前面
    /*public static void func(int[] array){
        int i = 0;
        int j = array.length - 1;
        while(i < j){
            while(i < j && array[i]%2 == 1) {
                i++;
            }
            while(i < j && array[j]%2 == 0){
                j--;
            }
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        func(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }*/
    /*public static void swap(int[] array){
        int tmp = array[0];
        array[0] = array[1];
        array[1] = tmp;
    }
    public static void main(String[] args) {
        int[] array = {10, 20};
        swap(array);
        System.out.println(array[0]+ " " + array[1]);

        *//*int a = 10;//局部变量 -> 栈上
        int[] array = {1,2,3,4,5};//定义整形数组 数组也是局部变量
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
        //foreach
        for (int b: array) {
            System.out.print(b + " ");
        }
        System.out.println();
        //操作数组的工具类
        String str = Arrays.toString(array);
        System.out.println(str);*//*


        *//*int[] array2 = new int[5];//定义一个整形数组
        for(int i = 0; i < array2.length; i++){
            System.out.print(array2[i] + " ");
        }*//*


        *//*int[] array3 = new int[ ]{1,2,3,4,5,6,7,8,9};
        //存地址的变量，我们称之为引用
        //array在栈上，但是后面的数字在堆上
        //System.out.println(array[5]);//访问数组不能越界
        System.out.println("数组的长度" + array.length);
        int[] array4 = null;
        System.out.println(array4);//输出null
        //System.out.println(array4.length);//报错*//*

    }*/

    //青蛙跳台阶，一次跳一节或者两节
    /*public static int jumpFloor(int n){
        if(n == 1 || n == 2){
            return n;
        }
        return jumpFloor(n-1) + jumpFloor(n-2);
    }
    public static void main(String[] args) {
        System.out.println(jumpFloor(4));
    }*/

    //汉诺塔
    /*public static void move(char pos1, char pos2){
        System.out.print(pos1 + "->" + pos2 + " ");
    }

    public static void hanoi(int n, char pos1, char pos2, char pos3) {
        if(n == 1){
            move(pos1, pos3);
        }
        else{
            hanoi(n-1,pos1, pos3, pos2);
            move(pos1, pos3);
            hanoi(n-1, pos2, pos1, pos3);
        }
    }

    public static void main(String[] args){
        hanoi(1, 'A', 'B', 'C');
        System.out.println('\n');
        hanoi(2, 'A', 'B', 'C');
    }*/

    /*public static void main(String[] args) {
        //输出 1000 - 2000 之间所有的闰年
        int year = 0;
        for(year = 1000; year <= 2000; year++){
            if((year%4 == 0 && year%100 == 0) || year%400 == 0){
                System.out.println(year + "是闰年");
            }
        }
    }*/
    //编写程序数一下 1到 100 的所有整数中出现多少个数字9
    //9,19,29,39,49,59,69,79,89,90,91,92,93,94,95,96,97,98,99
    /*public static void main(String[] args){
        int count = 0;
        for(int i = 1; i <= 100; i++){
            if(i%10 == 9){
                count++;
            }
            if(i/10 == 9){
                count++;
            }
        }
        System.out.println(count);
    }*/
}
