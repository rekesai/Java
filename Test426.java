import java.util.Arrays;
import java.util.Scanner;

public class Test426 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] ret = str.split(" ");
            int sum = 0;
            for(int i = 0; i < ret.length; i++){
                sum += Long.parseLong(ret[i]);
            }
            System.out.println(sum);
        }
    }

    /*
    输入描述:多个测试用例，每个测试用例一行。每行通过,隔开，有n个字符，n＜100
    输出描述:对于每组用例输出一行排序后的字符串，用','隔开，无结尾空格
    输入例子1:
    a,c,bb
    f,dddd
    nowcoder
    输出例子1:
    a,bb,c
    dddd,f
    nowcoder
    */
    public static void main4(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] ret = str.split(",");
            Arrays.sort(ret);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < ret.length; i++){
                if(i != ret.length-1){
                    sb.append(ret[i]).append(",");
                }
                else{
                    sb.append(ret[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }


    /*输入描述:多个测试用例，每个测试用例一行。每行通过空格隔开，有n个字符，n＜100
    输出描述:对于每组测试用例，输出一行排序过的字符串，每个字符串通过空格隔开
    输入例子1:
    a c bb
    f dddd
    nowcoder
    输出例子1:
    a bb c
    dddd f
    nowcoder
    */
    public static void main3(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] ret = str.split(" ");
            Arrays.sort(ret);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < ret.length; i++){
                if(i != ret.length-1){
                    sb.append(ret[i]).append(" ");
                }
                else{
                    sb.append(ret[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }


    /*输入描述:输入有两行，第一行n,第二行是n个空格隔开的字符串
    输出描述:输出一行排序后的字符串，空格隔开，无结尾空格
    输入例子1:
    5
    c d a bb e
    输出例子1:
    a bb c d e
    */
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();
            String[] ret = str.split(" ", n);
            Arrays.sort(ret);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < ret.length; i++){
                if(i != ret.length-1){
                    sb.append(ret[i]).append(" ");
                }
                else{
                    sb.append(ret[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }

    /*
    输入描述:输入数据有多组, 每行表示一组输入数据。每行不定有n个整数，空格隔开。(1 <= n <= 100)。
    输出描述:每组数据输出求和的结果
    输入例子1:1 2 3
            4 5
            0 0 0 0 0
    输出例子1: 6
              9
              0
    * */
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            String[] ret = str.split(" ");
            int sum = 0;
            for(String s : ret){
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }

}
