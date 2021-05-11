import javafx.scene.layout.Priority;
import sun.awt.image.ImageWatched;

import java.util.*;
public class Test511 {


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


    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        Heap heap = new Heap();
        heap.creatHeap(array);
        for(int i = 0; i < heap.elem.length; i++){
            System.out.print(heap.elem[i]+" ");
        }
        heap.heapSort();
        System.out.println();
        for(int i = 0; i < heap.elem.length; i++){
            System.out.print(heap.elem[i]+" ");
        }
    }
}
