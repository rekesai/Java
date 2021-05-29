import java.util.Stack;

public class Sort {
    /*堆排序
    * 时间复杂度：O(n*log2n)
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




    /*插入排序-每次拿出一个数字来与之前的数字比较，小于则交换，大于则出然后将这个数字放好，从前往后，逐渐将小的数字集中在前面
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
        for(int i = 0; i < array.length-1; i++){
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
    public void quickSort(int[] array){
        quick(array, 0, array.length-1);
    }
    public void quick(int[] array, int low, int high){
        if(low >= high){
            return;
        }
        int par = partition(array, low, high);
        quick(array, low, par-1);
        quick(array, par+1, high);
    }
    public int partition(int[]  array, int low, int high){
        int tmp = array[low];
        while(low < high){
            //从后向前遍历
            while(low < high && array[high] >= tmp){
                high--;
            }
            if(low >= high){
                array[low] = tmp;
                break;
            }
            else{
                array[low] = array[high];
            }
            //从前向后遍历
            while(low < high && array[low] <= tmp){
                low++;
            }
            if(low >= high){
                array[high] = tmp;
                break;
            }
            else{
                array[high] = array[low];
            }
        }
        return low;
    }


    //优化快排
    public void quickSort2(int[] array){
        quick2(array, 0, array.length-1);
    }
    public void quick2(int[] array, int low, int high){
        if(low >= high){
            return;
        }
        //优化2、当数据的数量小到一定程度的时候用插入更快
        //这里不能直接用之前写好的插入排序是因为前者是在数组中排序，现在需要的是一个区间而不是一个完整的数组
        if(high-low+1 < 100){
            insertSort2(array, low, high);
            return;
        }
        //优化1、三数取中-将下标为low、mid、high的值进行比较，把大小为中间的值放到第一个开始快排，能有效的在分割数组的时候平分数组
        int mid = (low + high) >>> 1;
        medianOfThree(array, low, mid, high);
        int par = partition(array, low, high);
        quick2(array, low, par-1);
        quick2(array, par+1, high);
    }
    public void insertSort2(int[] array, int low, int high){
        for(int i = low+1; i <= high; i++){
            int tmp = array[i];
            int j = i-1;
            for(; j >= low; j--){
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
    //交换low mid high    令array[mid] < array[low] < array[high]
    public void medianOfThree(int[] array, int low, int mid, int high){
        if(array[mid] > array[low]){
            int tmp = array[mid];
            array[mid] = array[low];
            array[low] = tmp;
        }
        if(array[mid] > array[high]){
            int tmp = array[mid];
            array[mid] = array[high];
            array[high] = tmp;
        }
        if(array[low] > array[high]){
            int tmp = array[low];
            array[low] = array[high];
            array[high] = tmp;
        }
    }



    //非递归的快速排序
    public void quickSort3(int[] array){
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





    /*归并排序-
    * 时间复杂度：对数据不敏感O(n*log2n)
    * 空间复杂度：O(n)
    * 稳定性：稳定
    *
    * 堆排序、快速排序、归并排序的时间复杂度都是O(n*log2n)
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
        while(s1 <= e1){
            tmp[k++] = array[s1++];
        }
        while(s2 <= e2){
            tmp[k++] = array[s2++];
        }
        for(int i = 0; i < tmp.length; i++){
            //将tmp数组中元素放回原来array数组，如果传过来的这个数组是array数组的后半段，low不是0，为了下标保持一致要加low
            array[i+low] = tmp[i];
        }
    }

    //非递归的归并排序
    public void mergeSort2(int[] array){
        for(int gap = 1; gap < array.length; gap *= 2){
            merge2(array, gap);
        }
    }
    public void merge2(int[] array, int gap){
        int[] tmpArr = new int[array.length];
        int k = 0;
        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 >= array.length ? array.length-1 : s2+gap-1;
        //确保两个区间都有数据
        while(s2 <= array.length){
            while(s1 <= e1 && s2 <= e2){
                if(array[s1] < array[s2]){
                    tmpArr[k++] = array[s1++];
                }
                else{
                    tmpArr[k++] = array[s2++];
                }
            }
            while(s1 <= e1){
                tmpArr[k++] = array[s1++];
            }
            while(s2 <= e2){
                tmpArr[k++] = array[s2++];
            }
            //以下四个区间边界都可能会发生越界，注意条件
            s1 = e2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s2 + gap - 1 >= array.length ? array.length-1 : s2+gap-1;
        }
        while(s1 < array.length){
            tmpArr[k++] = array[s1++];
        }
        for(int i = 0; i < tmpArr.length; i++){
            array[i] = tmpArr[i];
        }
    }
}
