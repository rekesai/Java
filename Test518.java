import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test518 {
    /**升序整数数组插入
     * 三行输入
     * 1、数字n表示下一行有几个数字
     * 2、输入n个数字用空格隔开
     * 3、输入要插入的数字
     */
    public static void insertNum(){
        //输入
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = s.nextInt();
        }
        int num = s.nextInt();
        //将数字整合进新数组
        int[] newArr = new int[array.length+1];
        int k = 0;
        for(; k < array.length; k++){
            newArr[k] = array[k];
        }
        newArr[k] = num;
        //插入排序
        for(int i = 1; i < newArr.length; i++){
            int tmp = newArr[i];
            int j = i - 1;
            for(; j >= 0; j--){
                if(newArr[j] > tmp){
                    newArr[j+1] = newArr[j];
                }
                else{
                    break;
                }
            }
            newArr[j+1] = tmp;
        }
        //输出
        System.out.print("[");
        for(int i = 0; i < newArr.length; i++){
            if(i == newArr.length-1){
                System.out.print(newArr[i]);
            }
            else{
                System.out.print(newArr[i]+" ");
            }
        }
        System.out.print("]");
    }


    /**
     *题目描述
     * 用筛选法求n以内的素数。筛选法求解过程为：将2~n之间的正整数放在数组内存储，将数组中2之后的所有能被2整除的数清0，
     * 再将3之后的所有能被3整除的数清0 ，以此类推，直到n为止。数组中不为0 的数即为素数。
     * 输入描述:
     * 多组输入，每行输入一个正整数（不大于100）。
     * 输出描述:
     * 针对每行输入的整数n，输出两行，第一行，输出n之内（包括n）的素数，用空格分隔，
     * 第二行，输出数组中2之后0 的个数。每行输出后换行。
     * 示例1
     * 输入
     * 20
     * 输出
     * 2 3 5 7 11 13 17 19
     * 11
     */
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            //输入
            int n = s.nextInt();
            //填充数组
            int[] array = new int[n-1];
            for(int i = 0; i < array.length; i++){
                array[i] = i+2;
            }
            //清零非素数
            int count = 0;
            for(int i = 2; i < n; i++){
                for(int j = i-1; j < array.length; j++){
                    if(array[j]%i == 0){
                        if(array[j] != 0){
                            array[j] = 0;
                            count++;
                        }
                    }
                }
            }
            //将非零数放入数组
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 0; i < array.length; i++){
                if(array[i] != 0){
                    arrayList.add(array[i]);
                }
            }
            //输出第一行
            for(int i = 0; i < arrayList.size(); i++){
                System.out.print(arrayList.get(i)+" ");
            }
            System.out.println();
            //输出第二行
            System.out.println(count);
        }
    }


    /**
     * 给定两个数组，编写一个函数来计算它们的交集
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums2[j]);
                }
            }
        }
        int[] ret = new int[set.size()];
        int k = 0;
        for (int i : set) {
            ret[k++] = i;
        }
        return ret;
    }



    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * 你可以假定该字符串只包含小写字母。
     * */
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        for(int i = 0; i < s.length(); i++){
            int n = s.charAt(i) - 97;
            array[n]++;
        }
        for(int i = 0; i < s.length(); i++){
            int n = s.charAt(i) - 97;
            if(array[n] == 1){
                return i;
            }
        }
        return -1;
    }



    /**
     * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。
     * 每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1
     * 以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
     * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。
     * 也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。
     * 例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/compare-version-numbers
     */
    public static int compareVersion(String version1, String version2) {
        //  “.”   需要转义
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int s1 = 0;
        int s2 = 0;
        while(s1 < str1.length && s2 < str2.length){
            int i = Integer.parseInt(str1[s1++]);
            int j = Integer.parseInt(str2[s2++]);
            if(i > j){
                return 1;
            }
            if(i < j){
                return -1;
            }
        }
        while(s1 < str1.length){
            if(Integer.parseInt(str1[s1++]) != 0){
                return 1;
            }
        }
        while(s2 < str2.length){
            if(Integer.parseInt(str2[s2++]) != 0){
                return -1;
            }
        }
        return 0;
    }
}
