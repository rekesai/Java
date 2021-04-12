public class MyArrayList {
    public int[] elem;//存储数据
    public int usedSize;//有效数据

    public MyArrayList(){
        this.elem = new int[10];
    }


    //展示表
    public void display() {
        for(int i = 0; i < this.usedSize; i++){
            System.out.print(this.elem[i]+" ");
        }
    }
    //在pos位置新增元素
    public void add(int pos, int data) {
        if(this.usedSize == this.elem.length){
            System.out.println("表满了！");
            return;
        }
        if(pos < 0 || pos > this.usedSize){
            System.out.println("pos位置不合法！");
            return;
        }
        for(int i = this.usedSize - 1; i >= pos; i--){
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    //判定是否包含某个元素
    public boolean contains(int toFind) {
        if(isEmpty()){
             System.out.println("顺序表为空！");
             return false;
        }
        for(int i = 0; i < this.usedSize; i++){
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    //判断顺序表是否为空
    public boolean isEmpty(){
        return this.usedSize == 0;
    }
    //查找某个元素对应的位置
    public int search(int toFind) {
        if(this.isEmpty()){
            System.out.println("顺序表为空！");
            return -1;
        }
        for(int i = 0; i < this.usedSize; i++){
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    //获取 pos 位置的元素
    public int getPos(int pos) { return -1; }
    //给pos位置的元素设为 value
    public void setPos(int pos, int value) {  }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {  }
    // 获取顺序表长度
    public int size() { return 0; }
    // 清空顺序表
    public void clear() { }

}
