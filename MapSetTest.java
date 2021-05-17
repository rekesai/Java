import java.util.*;

public class MapSetTest {

    //给定两个数组，编写一个函数来计算它们的交集
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



    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        String str = "1234";
        int n = Integer.parseInt(str);
        System.out.println(array.length);
        System.out.println(str.length());
        System.out.println("\\.");
    }

}
