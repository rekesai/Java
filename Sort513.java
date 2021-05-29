import java.util.Stack;

public class Sort513 {
    /*堆排序
     *时间复杂度：O(n*log2n)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public void heapSort(int[] array){
        creatHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(0, end, array);
            end--;
        }
    }
    public void creatHeap(int[] array){
        //p是每棵子树的根节点
        for(int p = (array.length-1-1)/2; p >= 0; p--){
            adjustDown(p, array.length, array);
        }
    }
    public void adjustDown(int parent, int len, int[] array){
        int child = parent*2 + 1;
        while(child < len){
            if(child+1 < len && array[child] < array[child+1]){
                child++;
            }
            if(array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = parent*2 + 1;
            }
            else{
                break;
            }
        }
    }




    /*插入排序
    时间复杂度：最好情况O(n)-原本就是有序的   最坏O(n^2)
    空间复杂度：O(1)
    稳定性：稳定
    稳定的排序可以变成不稳定的，但是不稳定的排序不能变成稳定
    插入排序特点：越有序越快
    * */
    public void insertSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int tmp = array[i];
            int j = i - 1;
            for(; j >= 0; j--){
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }
                else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }


    /*希尔排序
    时间复杂度：最好O(n)， 最坏建议O(n^1.3) ~ O(n^1.5)
    空间复杂度：O(1)
    稳定性：不稳定
    为什么希尔排序不直接将差距设为1，而是要从大到小来设置？
    希尔排序可以说是插入排序的优化版，插入排序太过于依赖数组的有序性，如果数组有序，插入排序则是最快的，若无序则要慢得多
    而希尔排序则是先完成数组的局部有序，再达到整体有序
    * */
    public void shellSort(int[] array){
        int[] gap = {5,3,1};
        for(int i = 0; i < gap.length; i++){
            shell(array, gap[i]);
        }
    }
    public void shell(int[] array, int gap){
        //
        for(int i = gap; i < array.length; i++){
            int tmp = array[i];
            int j = i - gap;
            for(; j >= 0; j-= gap){
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                }
                else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }



    /*选择排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * 选择排序是嵌套双循环，每次i不动j动，分别比较大小，顺序不对则交换，形成小的数字都集中在数组的前部
     * */
    public void selectSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
    public void selectSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //无序区间: [0, array.length - i)
            //有序区间: [array.length - i, array.length)
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[array.length - i - 1];
                    array[array.length - i - 1] = tmp;
                }
            }
        }
    }



    /*冒泡排序
    时间复杂度：最好O(n)   最坏O(n^2)
    空间复杂度：O(1)
    稳定性：稳定
    * */
    public void bubbleSort(int[] array){
        for(int i = 0; i < array.length-1; i++){
            boolean flag = true;
            for(int j = 0; j < array.length-1-i; j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }


    /*快速排序
    时间复杂度：最好O(n*log2n)  最坏数据有序的时候O(n^2)
    空间复杂度：最好O(log2n)    最坏O(n)
    稳定性：不稳定
    * */
    public int partition(int[] array, int low, int high){
        return 0 ;
    }
    public void quickSort(int[] array){

    }
    //非递归的快速排序
    public void quickSort2(int[] array){
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = array.length - 1;
        int par = partition(array, low, high);
        //1、分别判断 左右两边是否有两个元素以上，包含两个元素
        //左边有2个元素以上
        if(par > low+1) {
            //入栈：
            stack.push(low);
            stack.push(par-1);
        }
        //右边有2个元素以上
        if(par < high-1) {
            stack.push(par+1);
            stack.push(high);
        }
        while(!stack.isEmpty()){
            high = stack.pop();
            low = stack.pop();
            par = partition(array, low, high);
            if(par > low+1) {
                //入栈：
                stack.push(low);
                stack.push(par-1);
            }
            //右边有2个元素以上
            if(par < high-1) {
                stack.push(par+1);
                stack.push(high);
            }
        }
    }
    public void quick(int[] array, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low + high) >>> 1;
        medianOfThree(array, low, mid, high);
        //int pair = partition();
    }
    public void medianOfThree(int[] array, int low, int mid, int high){
        int start = mid;
        int end = high;
        mid = low;
        if(array[mid] > array[start]){
            int tmp = array[mid];
            array[mid] = array[start];
            array[start] = tmp;
        }
        if(array[start] > array[end]){
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
        }
        if(array[mid] > array[end]){
            int tmp = array[mid];
            array[mid] = array[end];
            array[end] = tmp;
        }
    }


    /*归并排序
     * 时间复杂度：对数据不敏感O(n*log2n)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     * */
    public void mergeSort(int[] array){
        mergeSortRec(array, 0, array.length-1);
    }
    public void mergeSortRec(int[] array, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (high + low) >>> 1;
        mergeSortRec(array, low, mid);
        mergeSortRec(array, mid+1, high);
        merge(array, low, mid, high);
    }
    public void merge(int[] array, int low, int mid, int high){
        int[] tmp = new int[high-low+1];
        int k = 0;//数组下标
        int s1 = low;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = high;
        while(s1 <= e1 && s2 <= e2){
            if(array[s1] < array[s2]){
                tmp[k++] = array[s1++];
            }
            else{
                tmp[k++] = array[s2++];
            }
        }

        //判断是数组1没走完还是数组2没走完
        if(s1 <= e1){
            tmp[k++] = array[s1++];
        }
        if(s2 <= e2){
            tmp[k++] = array[s2++];
        }
        for(int i = 0; i < tmp.length; i++){
            array[i+low] = tmp[i];
        }
    }


}
