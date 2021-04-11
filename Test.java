import java.util.Arrays;

class Calculator{
    private int num1;
    private int num2;
    //封装
    public int getNum1() {
        return num1;
    }
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public int getNum2() {
        return num2;
    }
    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add(){
        return num1 + num2;
    }
    public int sub(){
        return num1 - num2;
    }
    public int mul(){
        return num1 * num2;
    }
    public double div(){
        return num1*1.0 / num2;
    }
}

class MyValue{
    public int val;
}

public class Test {

//给定一个整型数组, 实现冒泡排序(升序排序)
//给定一个整型数组, 判定数组是否有序（递增）
//给定一个有序整型数组, 实现二分查找
//实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组.
//实现一个方法 toString, 把一个整型数组转换成字符串. 例如数组 {1, 2, 3} , 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量



    //实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组
    /*public static void myCopyOf(int[] array){
        int [] newarray =
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        myCopyOf(array);
    }*/


    //给定一个有序整型数组, 实现二分查找
    public static int binarySearch(int[] array, int key){
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while(left <= right){
            mid = (left+right)/2;
            if(array[mid] < key){
                left = mid + 1;
            }
            else if(key < array[mid]){
                right = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public static void binarySearchmain(String[] args) {
        int[]array = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(array, 7));
    }


    //给定一个整型数组, 判定数组是否有序（递增）
    public static boolean isOrder(int[] array){
        for(int i = 0; i < array.length-1; i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void isOrdermain(String[] args) {
        int[] array1 = {1,2,3,4,5,6,7,8,9};
        int[] array2 = {1,4,2,5,7,8,4,7,2};
        System.out.println(isOrder(array1));
        System.out.println(isOrder(array2));
    }



    //给定一个整型数组, 实现冒泡排序(升序排序)优化
    public static void bubbleSort2(int[] array){
        for(int i = 0; i < array.length; i++){
            boolean flg = true;
            for(int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flg = false;
                }
            }
            if(flg){
                break;
            }
        }
    }
    //给定一个整型数组, 实现冒泡排序(升序排序)
    public static void bubbleSort1(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
    public static void bubbleSortmain(String[] args) {
        int[] array1 = {9,8,7,6,5,4,3,2,1,0};
        bubbleSort1(array1);
        System.out.println(Arrays.toString(array1));
        int[] array2 = {9,8,7,6,5,4,3,2,1,0};
        bubbleSort2(array2);
        System.out.println(Arrays.toString(array2));
    }


    public static void swap(MyValue myValue1, MyValue myValue2){
        int tmp = myValue1.val;
        myValue1.val = myValue2.val;
        myValue2.val = tmp;
    }
    public static void mainswap(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.val = 10;
        MyValue myValue2 = new MyValue();
        myValue2.val = 20;
        System.out.println("交换前："+myValue1.val+" "+myValue2.val);
        swap(myValue1, myValue2);
        System.out.println("交换后："+myValue1.val+" "+myValue2.val);
    }


    public static void main1(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(10);
        calculator.setNum2(20);
        System.out.println(calculator.add());
        System.out.println(calculator.sub());
        System.out.println(calculator.mul());
        System.out.println(calculator.div());
    }

}
