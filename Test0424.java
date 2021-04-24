import java.util.Arrays;
import java.util.Scanner;



/*《泛型》
<T>,不能new泛型类型的数组 new T[]
基本数据类型不能作为泛型类型的参数（int、char之类），转而替代写的是他们的包装类，Integer
好处：1、可以在存放元素的时候，自动进行类型的检查
     2、获取元素的时候不需要进行强制类型转换
泛型到底是怎么工作的，怎么编译的？
  擦除机制：是在编译期间的一种机制。泛型的概念只存在于编译期间。编译期间将T类型擦除为Object

* */
class MyArrayList<T>{
    public T[] elem;
    public int usedSize;
    public MyArrayList(){
        this.elem = (T[])new Object[10];
    }
}

public class Test0424 {



    /*
    输入描述：多个测试用例，每个测试用例一行。每行通过空格隔开，有n个字符，n＜100
    输出描述：对于每组测试用例，输出一行排序过的字符串，每个字符串通过空格隔开
    示例1
    输入
    a c bb
    f dddd
    nowcoder
    输出
    a bb c
    dddd f
    nowcoder
    * */
    public static void main6(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            Arrays.sort(str);
            for(String s : str){
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }


    /*
    输入描述:输入有两行，第一行n，第二行是n个空格隔开的字符串
    输出描述:输出一行排序后的字符串，空格隔开，无结尾空格
    示例1
    输入
    5
    c d a bb e
    输出
    a bb c d e
    * */
    //冒泡排序
    public static void bubbleSort(String[] str){
        for(int i = 0; i < str.length-1; i++){
            boolean flag = true;
            for (int j = 0; j < str.length - 1 - i; j++) {
                if (str[j].compareTo(str[j+1]) > 0) {
                    String tmp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                return;
            }
        }
    }
    public static void main5(String[] args) {
        String[] str = new String[]{"a", "bb", "d", "c"};
        bubbleSort(str);
        System.out.println(Arrays.toString(str));
        //Arrays.sort(str);
        System.out.println(Arrays.toString(str));
    }


    /*
    输入描述:输入数据有多组, 每行表示一组输入数据。每行不定有n个整数，空格隔开。(1 <= n <= 100)。
    输出描述:每组数据输出求和的结果
    输入
    1 2 3
    4 5
    0 0 0 0 0
    输出
    6
    9
    0
    * */
    public static void main4(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            String str = sc.nextLine();
            String[] ret = str.split(" ");
            int sum = 0;
            for(String s : ret) {
                sum += Integer.parseInt(s);//将s变为整数，返回值为int
            }
            System.out.println(sum);
        }
    }



    public static void main3(String[] args){
        String str = "12344";
        String[] ret = str.split(" ");
        for (String s : ret) {
            System.out.println(Integer.valueOf(s));
        }
        int[] array = {1,2,3,4,5};
        for (int value : array) {
            System.out.println(value);
        }
    }


    //逆序部分字符串
    public static void reverse(int i, int j, char[] chars){
        while(i < j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }
    public static String reverseFunc(int size, String str){
        char[] chars = str.toCharArray();
        reverse(0,size-1, chars);
        reverse(size, chars.length-1, chars);
        reverse(0, chars.length-1, chars);
        return String.valueOf(chars);
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        //从下标为size初逆序
        int size = sc.nextInt();
        String str = sc.next();//nextLine会读取空格  next不读取
        String ret = reverseFunc(size,str);
        System.out.println(ret);
    }




    //逆序部分字符串
    public static String reverse(String str){
        if(str == null) return null;
        if(str.equals("")){
            return str;
        }
        //1、str转数组
        char[] chars = str.toCharArray();
        //2、逆序数组

        //return new String(chars);
        return String.valueOf(chars);
    }
    public static void main1(String[] args){
        String str = "zxciscool";
        String ret = str.toUpperCase();//转大写
        System.out.println(ret);
        ret = ret.toLowerCase();//转小写
        System.out.println(ret);
        reverse(ret);
    }
}
