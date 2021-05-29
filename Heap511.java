import com.sun.xml.internal.ws.server.UnsupportedMediaException;

import java.util.*;

public class Heap511 {
    public int[] elem;
    public int usedSize;
    public Heap511(){
        this.elem = new int[10];
    }

    public void adjustDown(int parent, int len){
        int child = parent*2 + 1;
        while(child < len){
            //判断是否具有右孩子，每次的child必定为parent的左孩子，若是child+1小于len则说明有右孩子
            //若左孩子的值小于右孩子则将child调整为右孩子进入下一步
            if(child+1 < len && this.elem[child] < this.elem[child+1]){
                child++;
            }
            //这里的child必定为左右孩子中的最大值
            if(this.elem[child] > this.elem[parent]){
                int tmp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = tmp;
                //重置parent和child位置，判断子树，自上向下
                parent = child;
                child = parent*2 + 1;
            }
            else{
                break;
            }
        }
    }
    //将一个整数数组变成大堆搜索树
    public void creatHeap(int[] array){
        //为elem数组赋值
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //调整树及子树
        for (int p = (this.usedSize-1-1)/2; p >= 0 ; p--) {
            adjustDown(p, this.usedSize);
        }
    }


    //自下向上判断，这是在加入新节点的情况下
    public void adjustUp(int child){
        int parent = (child-1) / 2;
        while(child > 0){
            if(this.elem[child] > this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                parent = (child-1) / 2;
            }
            else{
                break;
            }
        }
    }
    //加入新节点key
    public void push(int key){
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem, this.elem.length*2);
            System.out.println("满了!已扩容。");
        }
        this.elem[this.usedSize] = key;
        this.usedSize++;
        adjustUp(this.usedSize-1);
    }
    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }


    //出堆-出优先级最高的节点也就是堆顶元素
    public int pop() throws UnsupportedMediaException {
        if(isEmpty()){
            throw new UnsupportedOperationException("优先级队列为空！");
        }
        int ret = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.usedSize--;
        adjustDown(0,this.usedSize);
        return ret;
    }

    //得到堆顶元素
    public int getTop() throws UnsupportedMediaException{
        if(isEmpty()){
            throw new UnsupportedOperationException("优先级队列为空！");
        }
        return this.elem[0];
    }

    //是否空
    public boolean isEmpty(){
        return this.usedSize == 0;
    }


    //用大堆来进行数组从小到大的排序
    public void heapSort(){
        int end = this.elem.length - 1;
        while (end > 0) {
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            adjustDown(0, end);
            end--;
        }
    }



    //求和最小的K对数字
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        /*PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> {
            return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
        });*/
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
            }
        });
        for(int i = 0; i < Math.min(nums1.length, k); i++){
            for(int j = 0; j < Math.min(nums2.length, k); j++){
                if(queue.size() == k && nums1[i]+nums2[j] > queue.peek().get(0) + queue.peek().get(1)){
                    break;
                }
                if(queue.size() == k){
                    queue.poll();
                }
                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[i]);
                pair.add(nums2[j]);
                queue.add(pair);
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < k && !queue.isEmpty(); i++){
            res.add(queue.poll());
        }
        return res;
    }


    //求前K个最大的数
    public static void topK(int[] array, int k){
        //建立大小为K的小堆
        PriorityQueue<Integer> minHeap = new
                PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;           //这是小堆，反之大堆
            }
        });
        //遍历数组元素将前K个放入堆中
        for(int i = 0; i < array.length; i++){
            if(i < k){
                minHeap.offer(array[i]);
            }
            else{
                //从K+1个数组元素继续遍历，每次与堆顶元素进行比较，大则将堆顶元素出堆，将大元素放入，调整小堆
                if(array[i] > minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(array[i]);
                }
            }
        }
        //输出堆中元素
        System.out.print(minHeap);
    }


}