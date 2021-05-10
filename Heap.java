public class Heap {
    public int[] elem;
    public int usedSize;
    public Heap(){
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
            if(this.elem[parent] < this.elem[child]){
                int tmp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = this.elem[parent];
                //重置parent和child位置，判断子树，自上向下
                parent = child;
                child = parent*2 + 1;
            }
            else{
                break;
            }
        }
    }

    public void creatHeap(int[] array){
        //为elem数组赋值
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //调整树及子树
        for (int p = (usedSize-1-1)/2; p >= 0 ; p--) {
            adjustDown(p, usedSize);
        }
    }
}
