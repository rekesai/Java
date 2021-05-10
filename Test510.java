import java.util.Scanner;

public class Test510 {
    //判断str2是不是str1的子串，如果是则返回str1中子串开始的下标-不能用方法
    public static int BF(String str1, String str2){
        int i = 0;
        int j = 0;
        while(j < str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }
            else{
                //如果str1为aaabbc  str2为aabbc，返回的就得多一点
                i = i - j +1;
                j = 0;
            }
        }
        if(j == str2.length()){
            return i-j;
        }
        return -1;
    }


    //给一个数字n，判断是不是2的k次方-让n和n-1相与，得0则true，不得0则false
    public static boolean isTow(int n){
        return (n & (n-1)) == 0;
    }


    //合并两个有序数组-给两个有序数组，将nums2合并到nums1中，nums1还是有序数组
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int[] newNums = new int[m+n];
        int i = 0;
        int s1 = 0;
        int s2 = 0;
        while(s1 < m && s2 < n){
            if(nums1[s1] > nums2[s2]){
               newNums[i] = nums2[s2];
               s2++;
            }
            else{
                newNums[i] = nums1[s1];
                s1++;
            }
            i++;
        }
        while(s1 < m){
            newNums[i] = nums1[s1];
            s1++;
            i++;
        }
        while(s2 < n){
            newNums[i] = nums2[s2];
            s2++;
            i++;
        }
        for(int k = 0; k < m+n; k++){
            nums1[k] = newNums[k];
        }
    }



    //给定一个有序整数数组，删除其中重复的数字，返回新数组长度
    public static int removeDuplicates(int[] array){
        if(array == null || array.length == 0) return 0;
        int slow = 0;
        int fast = 1;
        return slow+1;
    }



    public static void main(String[] args) {

    }

    //输入两个字符串，删除第一个字符串中与第二个字符串中重复的字符
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String strChild = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(!sb.toString().contains(ch+"")){
                    sb.append(ch);
                }
            }
            System.out.println(sb);
        }
    }

    //输入一个字符串，删除其中重复的部分，顺序不变，可能多组输入
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(!sb.toString().contains(ch+"")){
                    sb.append(ch);
                }
            }
            System.out.println(sb);
        }
    }
}