import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Test522 {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     * 链接：https://leetcode-cn.com/problems/two-sum
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    ret[0] = i;
                    ret[1] = j;
                }
            }
        }
        return ret;
    }

    /**
     * 黑板上写着一个非负整数数组 nums[i] 。Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。如果擦除一个数字后，剩余的所有数字按位异或运算得出的结果等于 0 的话，当前玩家游戏失败。 (另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。）
     * 换种说法就是，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。
     * 假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。
     * 示例：
     * 输入: nums = [1, 1, 2]
     * 输出: false
     * 解释:
     * Alice 有两个选择: 擦掉数字 1 或 2。
     * 如果擦掉 1, 数组变成 [1, 2]。剩余数字按位异或得到 1 XOR 2 = 3。那么 Bob 可以擦掉任意数字，因为 Alice 会成为擦掉最后一个数字的人，她总是会输。
     * 如果 Alice 擦掉 2，那么数组变成[1, 1]。剩余数字按位异或得到 1 XOR 1 = 0。Alice 仍然会输掉游戏。
     * 链接：https://leetcode-cn.com/problems/chalkboard-xor-game
     */
    public boolean xorGame(int[] nums) {
        //Alice先擦，如果黑板上的数字数量是偶数，那么Alice必胜，反之，如果是奇数，Bob必胜
        if(nums.length%2 == 0){
            return true;
        }
        int num = 0;
        for(int i : nums){
            num ^= i;
        }
        return num == 0;
    }



    /**
     * 寻找一个数字与斐波那契数列最小的距离
     */
    public static void Fib(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;
        while(f2 < n){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        int ret = Math.min(n - f1, f2 - n);
        System.out.println(ret);
    }



    /**
     * 输出多少种字符串
     */
    public static void menu(){
        Scanner s = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while(!s.hasNext(",")){
            set.add(s.next());
        }
        System.out.println(set.size());
    }



    public static void main(String[] args){
        int[] array = {1,2,3,4,5};
        for (int i: array) {
            System.out.print(i);
        }
        int left = 0;
        int right = array.length-1;
        while(left < right){
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        for (int i: array) {
            System.out.print(i);
        }
    }
}
