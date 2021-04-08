import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    /*public static void main(String[] args) {
        int[][] array2 = new int[2][];
        //可以省略列不能省略行，此时的二维数组叫做不规则数组
        array2[0] = new int[2];
        array2[1] = new int[5];
        System.out.println(Arrays.deepToString(array2));
    }*/


    /*public static void main(String[] args) {
        int[][] array = new int[2][3];
        int[][] array2 = {{1, 2, 3}, {4, 5, 6}};
        int[][] array3 = new int[][]{{1,2,3},{4,5,6}};
        for (int i = 0; i < array2.length; i++){
            for(int j = 0; j < array2[i].length; j++){
                System.out.print(array2[i][j]+ " ");
            }
            System.out.println();
        }
    }*/


    //逆序数组
   /*public static void reverse(int[] array){
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(array));
        reverse(array);
        System.out.println(Arrays.toString(array));
    }*/


    //冒泡排序
    /*public static int[] bubbleSort(int[] array){
        for(int i = 0; i < array.length-1; i++){
            boolean flg = false;
            for(int j = 0; j < array.length-i-1; j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(flg == false){//如果没变证明没有进行交换，也就是顺序没错
                break;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {1,5,3,7,4,9,3,8};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }*/


    //判断数组是否升序
    /*public static boolean isSorted(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] array = {1,2,4,3,6,9};
        System.out.println(isSorted(array));
    }*/


    //二分查找
    /*public static int binarySearch(int[] array, int key){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(array[mid] > key){
                right = mid - 1;
            }
            else if(array[mid] < key){
                left = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        int ret = binarySearch(array, key);
        System.out.println(ret);
    }*/


    //查询数组中某一个特定的值的下标
    /*public static int findNum(int[] array, int key){
        for (int i = 0; i < array.length ; i++) {
            if(array[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(findNum(array, 2));
    }*/


    //求数组中最大数字
    /*public static void main(String[] args) {
        int[] array = {1,5,3,4,7,56,9};
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        System.out.println(max);
    }*/

    /*public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        //Java中的范围都是左闭右开
        int[] ret = Arrays.copyOfRange(array, 1, 3);//2,3
        System.out.println(Arrays.toString(ret));
    }*/

    /*
    深拷贝：改动拷贝之后的数组的值不会改变原数组的值
    浅拷贝：数组中放的是引用类型？？？

    * */
    /*public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] ret = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(ret));
    }*/

    /*public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] ret = array.clone();
        //clone产生当前对象的一个副本
        System.out.println(Arrays.toString(ret));
    }*/


    //复制数组
    /*public static int[] copyArray(int[] array){
        int[] tmp = new int[array.length];
        for(int i = 0; i < array.length; i++){
            tmp[i] = array[i];
        }
        return tmp;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] ret = copyArray(array);
        System.out.println(Arrays.toString(ret));

    }*/


    //模仿Arrays.ToString
    /*public static String myToString(int[] array){
        if(array == null){
            return null;
        }
        String ret = "[";
        for(int i = 0; i < array.length; i++){
            ret += array[i];
            if(i != array.length - 1){
                ret += ",";
            }
        }
        ret += "]";
        return ret;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(myToString(array));
    }*/



    //给数组赋值1-100
    /*public static void main(String[] args){
        int[] array = new int[100];
        for(int i = 0; i < 100; i++){
            array[i] = i + 1;
        }
        for(int i = 0; i < 100; i++){
            System.out.println(array[i]);
        }
    }*/
}
