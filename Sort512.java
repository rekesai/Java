public class Sort512 {
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
    时间复杂度：最好O(n)， 最坏建议O(n^1,3) ~ O(n^1.5)
    空间复杂度：O(1)
    稳定性：不稳定
    * */
    public void shellSort(int[] array){
        int[] gap = {5,3,1};
        for(int i = 0; i < gap.length; i++){
            shell(array, gap[i]);
        }
    }
    public void shell(int[] array, int gap){
        for(int i = gap; i < array.length; i+= gap/*这里加1也可以*/){
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
     * */
    public void selectSort(int[] array) {
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
}
