import java.util.*;


public class Test519 {
    /**
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     * 构造这个链表的深拷贝。深拷贝应该正好由 n个全新节点组成，其中每个新节点的值都设为其对应的原节点的值。
     * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
     * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
     * 返回复制链表的头节点。
     * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
     * val：一个表示 Node.val 的整数。
     * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
     * 你的代码 只 接受原链表的头节点 head 作为传入参数。
     * 示例 1：
     * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 示例 2：
     * 输入：head = [[1,1],[2,1]]
     * 输出：[[1,1],[2,1]]
     * 示例 3：
     * 输入：head = [[3,null],[3,0],[3,null]]
     * 输出：[[3,null],[3,0],[3,null]]
     * 示例 4：
     * 输入：head = []
     * 输出：[]
     * 解释：给定的链表为空（空指针），因此返回 null。
     * 提示：
     * 0 <= n <= 1000
     * -10000 <= Node.val <= 10000
     * Node.random 为空（null）或指向链表中的节点。
     * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
     */
    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        //遍历旧链表，建立新节点，与旧节点按照链表的顺序通过map建立联系，并赋上相应的节点的val
        //Map<key, val> key为旧节点，val为新节点
        while(cur != null){
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        //令cur重新指回head，将新节点与旧节点之间的next、random关系也复制一遍
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        //返回新链表的头部
        return map.get(head);
    }



    /**
     *链接：https://www.nowcoder.com/questionTerminal/f88dafac00c8431fa363cd85a37c2d5e
     * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
     * 肯定坏掉的那些键。
     * 输入描述:
     * 输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
     * 以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
     * 输出描述:
     * 按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
     * 示例1
     * 输入
     * 7_This_is_a_test
     * _hs_s_a_es
     * 输出
     * 7TI
     */
    public void badKeyboard(){
        Scanner s = new Scanner(System.in);
        String strExc = s.nextLine();
        String strAct = s.nextLine();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < strAct.length(); i++){
            char ch = strAct.toUpperCase().charAt(i);
            set.add(ch);
        }
        HashSet<Character> brokenSet = new HashSet<>();
        for(int i = 0; i < strExc.length(); i++){
            char ch = strExc.toUpperCase().charAt(i);
            if(!set.contains(ch) && !brokenSet.contains(ch)){
                brokenSet.add(ch);
                System.out.print(ch);
            }
        }
    }





    /**
     * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * 示例 1:
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     * 示例 2:
     * 输入: J = "z", S = "ZZ"
     * 输出: 0
     * 注意:
     * S 和 J 最多含有50个字母。
     * J 中的字符不重复。
     * 链接：https://leetcode-cn.com/problems/jewels-and-stones
     */
    //字符串做法
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for(int i = 0; i < stones.length(); i++){
            for(int j = 0; j < jewels.length(); j++){
                if(stones.charAt(i) == jewels.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }
    //set做法
    public int numJewelsInStones2(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < jewels.length(); i++){
            set.add(jewels.charAt(i));
        }
        int count = 0;
        for(int i = 0; i < stones.length(); i++){
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }



    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     * 链接：https://leetcode-cn.com/problems/single-number
     * 异或最简单，硬拿set写
     */
    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }
            else{
                set.add(nums[i]);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
        }
        //迭代器
        /*Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            return it.next();
        }*/
        return -1;
    }

    public static void main4(String[] args) {
        int[] array = {1,2,2,3,3,4,4,5,5};
        System.out.println(singleNumber(array));
    }


    /**
     * 统计list中的数字分别出现了多少次
     * 统计出现几次用HashMap比较好，因为它的结构就是两个参数，一个为key，一个为val--key为关键字，val为这个关键字出现了几次
     */
    public static void repeatNum(){
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 10_0000; i++){
            list.add(random.nextInt(100)+1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            Integer key = list.get(i);
            if(map.containsKey(key)){
                int count = map.get(key);
                map.put(key, count+1);
            }
            else{
                map.put(key,1);
            }
        }
        System.out.println(map);
    }


    /**
     * 如果list中有十万个数据，找出第一个重复的数据
     */
    public static int findOneRepeat(){
        //创建表并放入范围在1-100之间的十万个数字
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 10_0000; i++){
            list.add(random.nextInt(100));
        }

        //定义哈希set并遍历表中元素，若set中有则是重复的第一个并输出，若没有则加入set中。set的特性是不重复
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < list.size(); i++){
            Integer val = list.get(i);
            if(set.contains(val)){
                return val;
            }
            set.add(val);
        }
        //再定义一个表，如果表中有这个元素就输出，如果没有就加入，和上面的set是一样的效果
        /*ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            int val = list.get(i);
            if(list2.contains(val)){
                return val;
            }
            list2.add(val);
        }*/
        return -1;
    }
    public static void main3(String[] args) {
        System.out.println(findOneRepeat());
    }






    public static void main2(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(3);
        set.add(2);
        System.out.println(set);
        Object[] array= set.toArray();
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
    public static void main1(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("老干妈", 1);
        map.put("晚饭", 5);
        System.out.println(map);
    }

}
