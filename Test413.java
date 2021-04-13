
//实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
//实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
//实现一个方法 transform,以数组为参数,循环将数组中的每个元素乘以2,并设置到对应的数组元素上,如原数组为{1,2,3},修改之后为{2,4,6}
//实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
//创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
public class Test413 {
    public static int sum(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    public static int avg(int[] array){
       return sum(array)/array.length;
    }
    public static void tranForm(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = 2*array[i];
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public static void newArray(){
        int[] array = new int[100];
        for(int i = 0; i < array.length; i++){
            array[i] = i+1;
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(sum(array));
        System.out.println(avg(array));
        tranForm(array);
        printArray(array);
        newArray();
    }


    public static void myArrayList1main(String[] args) {
        MyArrayList myArrayList1 = new MyArrayList();
        System.out.println(myArrayList1.isEmpty());
        myArrayList1.add(0,0);
        myArrayList1.add(1,1);
        myArrayList1.add(2,2);
        myArrayList1.add(3,3);
        myArrayList1.add(4,4);
        myArrayList1.display();
        System.out.println(myArrayList1.getPos(0));
        System.out.println(myArrayList1.getPos(5));
        System.out.println("===================");
        myArrayList1.remove(1);
        myArrayList1.remove(4);
        myArrayList1.display();
        myArrayList1.clear();
        myArrayList1.display();
        myArrayList1.add(0,0);
        myArrayList1.add(1,1);
        myArrayList1.add(2,2);
        myArrayList1.add(3,3);
        myArrayList1.add(4,4);
        myArrayList1.display();
        System.out.println("===================");
        myArrayList1.remove(4);
        myArrayList1.remove(3);
        myArrayList1.remove(0);
        myArrayList1.remove(1);
        myArrayList1.display();
    }
}
