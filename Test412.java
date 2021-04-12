import java.util.Arrays;

public class Test412 {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.showList();
    }

    public static void MyArrayListmain(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.add(3,4);
        myArrayList.add(4,99);
        myArrayList.add(5,88);
        myArrayList.add(3,10);
        myArrayList.display();
        System.out.println(myArrayList.contains(10));
    }


//给定一个整型数组,实现冒泡排序(升序排序)
//给定一个整型数组,判定数组是否有序（递增）
//给定一个有序整型数组,实现二分查找
//实现一个方法 copyOf,对一个整型数组进行拷贝, 得到一个新的数组.
//实现一个方法 toString,把一个整型数组转换成字符串.例如数组 {1, 2, 3},返回的字符串为"[1, 2, 3]",注意逗号的位置和数量


    //实现一个方法 toString, 把一个整型数组转换成字符串
    //例如数组 {1, 2, 3} , 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量
    public static void myToString(int[] array){
        System.out.print("[");
        for(int i = 0; i < array.length; i++){
            if(i != array.length-1){
                System.out.print(array[i]+", ");
            }
            else{
                System.out.print(array[i]);
            }
        }
        System.out.println("]");
    }
    public static void myToStringmain(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        myToString(array);
    }


    //实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组
    public static int[] myCopyOf(int[] array){
        int [] myArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            myArray[i] = array[i];
        }
        return myArray;
    }
    public static void myCopyOfmain(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(myCopyOf(array)));
    }


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
}
