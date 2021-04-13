import java.util.Arrays;

public class MyArrayList1 {
    public int[] elem;//存储数据数组
    public int usedSize;//有效数据数

    public MyArrayList1(){
        this.elem = new int[10];
    }

    //展示表
    public void display() {
        if (this.isEmpty()) {

            System.out.println("当前顺序表为空！");
            return;
        }
        for(int i = 0; i < this.usedSize; i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    //在pos位置新增元素
    public void add(int pos, int data) {
        if (this.usedSize == this.elem.length) {

            System.out.println("顺序表满了，需要扩容！");
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
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
        System.out.println("您输入的"+toFind+"不存在！");
        return -1;
    }
    //获取 pos 位置的元素
    public int getPos(int pos) {
        if(this.isEmpty()){
            System.out.println("当前顺序表为空！");
            return -1;
        }
        if(pos < 0 || pos > this.usedSize - 1){
            System.out.println("pos位置不合法！");
            return -1;
        }
        return this.elem[pos];
    }
    //给pos位置的元素设为 value
    public void updatePos(int pos, int value){
        if(this.isEmpty()){
            System.out.println("当前顺序表为空！");
            return;
        }
        if(pos < 0 || pos > this.usedSize - 1){
            System.out.println("pos位置不合法！");
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int key) {
        if(this.isEmpty()){
            System.out.println("当前顺序表为空！");
            return;
        }
        int index = this.search(key);
        if(key == -1){
            System.out.println("您需要删除的"+key+"不存在！");
            return;
        }
        for(int i = index; i < this.usedSize - 1; i++){
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
        /*for(int i = 0; i < this.usedSize; i++){
            if(this.elem[i] == key){
                while (i < this.usedSize - 1) {
                    this.elem[i] = this.elem[i + 1];
                    i++;
                }
                this.usedSize--;
                return;
            }
        }
        System.out.println("您需要删除的"+key+"不存在！");*/
    }
    // 获取顺序表长度
    public int size(){
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }

}
