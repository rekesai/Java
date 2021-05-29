import java.util.*;
public class Test56 {

    public static int getResult(int n) {
        LinkedList<Integer> res = new LinkedList<>();
        int round = 2;
        int i = 0;
        int cur = 0;
        for (i = 1; i <= n; i++) {
            res.add(i);//将n个人放入表中
        }
        while (res.size() > 1) {
            i = 0;
            while (res.size() > 1 && i < res.size()) {
                cur = (cur + 1) % round;
                if (cur != 1){//数的不是1便踢出
                    res.remove(i);
                }
                else{
                    i++;
                }
            }
            for (Integer s : res) {
                System.out.print(s+" ");
            }
            System.out.println();
            round++;//从2,3,4递增
            cur = 0;
            if (res.size() > 1) {
                //完成链表中元素的逆序
                int last = res.removeLast();//返回链表中最后一个元素
                res.addFirst(last);//放到头
            }
            for (Integer s : res) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
        return res.pop();
    }

    public static int getResult2(int n){
        Stack<Integer> st1 = new Stack<>();
        for(int i = n; n > 0; n--){
            st1.push(n);
        }
        int round = 2;
        Stack<Integer> st2 = new Stack<>();

        while((st1.size()!=1&&st2.size()==0) || (st2.size()!=1&&st1.size()==0)){
            if(st2.isEmpty()){
                while(!st1.isEmpty()){
                    int num = st1.pop();
                    if(num % round == round-1){
                        st2.push(num);
                    }
                }
            }
            else{
                while(!st2.isEmpty()){
                    int num = st2.pop();
                    if(num % round == round-1){
                        st1.push(num);
                    }
                }
            }
            round++;
        }

        if(st1.isEmpty()){
            return st2.pop();
        }
        else{
            return st1.pop();
        }
    }

    public static List<List<Integer>> generate(int numRows){
        if(numRows == 0){
            return null;
        }
        //创建用来接收的二维数组，每一个单独的一位数组都是这个二维数组中的一个元素
        List<List<Integer>> ret = new ArrayList<>();

        //第一行
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ret.add(list);        //接收第一行

        //从第二行开始
        for(int i = 1; i < numRows; i++){
            List<Integer> listRow = new ArrayList<>();
            listRow.add(1);       //第一个位置
            //从第二个位置开始到倒数第二个位置-中间位置
            for(int j = 1; j < i; j++){
                //获取二维数组ret的第i-1(i是从1开始的，当i为1时就是获取第0个元素)个元素，也是一个数组
                List<Integer> listPrev = ret.get(i-1);
                int val = listPrev.get(j) + listPrev.get(j-1);  //将这个数组中的第j和j-1个元素加起来
                listRow.add(val);       //加入到当前行中
            }
            listRow.add(1);         //最后一个位置
            ret.add(listRow);       //接收每一行
        }
        return ret;
    }

    public static void main(String[] args){
        //generate(0);
        System.out.println(getResult(3));
    }

}
