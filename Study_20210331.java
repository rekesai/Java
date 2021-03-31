public class Test {
	/*
	java中基本数据类型：
	数据类型：byte   char     short   int     long  float  double  boolean
	包装类：  Byte  Character  Short  Integer  Long  Float  Double  Boolean
	字节数：   1 	  2 	   2      4        8     4      8     没有规定
	java中引用数据类型：类、字符串String、数组、抽象类、接口、枚举
	*/


	public static void main1(String[] args) {
		int num1 = 10;
		String str1 = num1 + "";//将整形转换成字符串1
		String str2 = String.valueOf(num1);//将整形转换成字符串2
		System.out.println(str1);//10
		System.out.println(str2);//10
		String str3 = "100";
		int num2 = Integer.parseInt(str3);//将字符串转换成整形
		System.out.println(num2);//100

	}


	/*
	隐式类型转换：把一个小类型数据给大类型数据
	显式类型转换：把一个大类型数据赋值给小类型，需要强行转换
	可以将范围小的数据类型赋值给范围大的数据类型，不能把范围大的数据类型赋值给范围小的数据类型
	例如：可以将int赋给long、double，但是不能将后面二者赋值给前者
	int不能跟boolean类型相互赋值，两个是完全不同的东西
	*/
	public static void main2(String[] args) {
		long a = 10L;
		//int b = a;//不兼容的类型：从long转换到int可能会有损失
		int b = (int)a;//强行转换成int才可以
		System.out.println(b);
	}


	/*
	final修饰常量无法被修改
	*/
	public static void main3(String[] args) {
		final int maxNum = 10;
		maxNum = 20;//编译出错，无法为最终变量a分配值
		System.out.println(maxNum);//10
	}


  	public static void main4(String[] args) {
	  	int a = 10;
	  	int b = 20;
	  	System.out.println("a = " + a +",b = " + b); //a= 10,b = 20
   	}


	public static void main5(String[] args) {
		//由于计算机的CPU通常是按照4分字节为单位从内存中读写数据，
		//为了硬件上实现方便，诸如byte（1）、short（2）、char（2,字节，但一般用来字符）
		//这些小于四个字节的类型，会先提升成int再进行计算
		//byte a = 127 + 1;//会报错
		//System.out.println(a);
		byte b = (byte)(127 + 1);//强行转化类型
		System.out.println(b);// -128
	}


  	/*
	字符串数据类型：String
	*/
    public static void main6(String[] args) {
		String str1 = "hello";
		String str2 = "\"hello\"";
		String str3 = "\\hello\\";
		System.out.println(str1);//  hello
		System.out.println(str2);//  “hello”  转义字符\"表示双引号
		System.out.println(str3);//  \hello\  转义字符\\表示一个斜杠
	}


    //(String[] args)这个的作用是运行时的参数，数组在堆上
	public static void main7(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);//将输入的参数输出（在执行java文件时）
		}
		System.out.println("biabiabia");//输出biabiabia
		double a = 1.1;//double双精度，8个字节，最好使用double而不是float
						//float单精度精确表示小数点后6位，4个字节
		System.out.println(a);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		System.out.println(a * a);//输出1.21000000002，精度原因
	}


    //基本数据类型  		   int       long   double 	  float
    //包装类-->后期使用方便  Integer   Long   Double    Float
	public static void main8(String[] args) {
		long a = 10; //这里的10只是整形
		long b = 10L; //这里的10才是长整形
		int c = 20;
		System.out.println(a);//输出10
		System.out.println(b);//输出10
		System.out.println("a的值是：" + a);//a的值是： 10
		System.out.println("b的值是：" + b);//b的值是： 20
		System.out.println("最大值：" + Long.MAX_VALUE);// + 为拼接,用来拼接字符串
		System.out.println("最小值：" + Long.MIN_VALUE);//大写的L为包装类 
		System.out.println(a + c);//这里的 + 是运算符号，输出30
		System.out.println(b + c);//输出30
		System.out.println(a + b);//输出20
	   	System.out.println("hhh" + a + b);//hhh1010，数据和字符串进行拼接，结果为字符串，不会进行计算
		System.out.println("hhh" + (a + b));//hhh20加了括号之后就可以先计算再拼接
	}


	/*
	单精度浮点数：float  4个字节
	*/
	public static void main9(String[] args) {
		//float e = 12.2;//会报错，java不允许把一个double类型的值赋给比自己小的float类型
		//java是强类型语言，C语言是弱类型语言
		float f = 12.2F;
		System.out.println(f);
		System.out.println(Float.MAX_VALUE);//3.4028235E38
		System.out.println(Float.MIN_VALUE);//1.4E-45
		
	}

	
	/*
	字符数据类型： char 2个字节  范围0-65535  没有负数  
	一般都为字符或者汉字
	包装类为Character
	Unicode字符集-->包含了更多字符
	*/
	public static void main10(String[] args) {
		char ch ='a';
		System.out.println(ch);
		char ch1 = 97;//Unicode字符集中包含ASC码，其中97对应小写字母a
		System.out.println(ch1);
		char ch2 = 98;//小写字母b
		System.out.println(ch2);
	}


	/*
	字节：byte 1个字节   数值 -128--127
	每一种数据类型在复制的时候不能超过取值范围
	*/
    public static void main11(String[] args) {
		byte b = 12;
		byte c = 21;
		System.out.println(b + " " + c);//12  21
		System.out.println(Byte.MAX_VALUE);//127
		System.out.println(Byte.MIN_VALUE);//-128
		System.out.println(Byte.MAX_VALUE + 1);//128  println默认是以整形打印的
		System.out.println(Integer.MAX_VALUE + Byte.MAX_VALUE);//-2147483522,2147483647+127=-2447483648+126
	}


	/*
	短整型：short  2个字节   -32768 -- 32767
	*/
	public static void main12(String[] args) {
		short sh = 12;
		System.out.println(Short.MAX_VALUE);//32767
		System.out.println(Short.MIN_VALUE);//-32768
	}


	/*
	布尔类型：boolean
	在java中布尔类型没有明确的大小
	只有两个取值   true  false
	在java中没有c语言中的0为假，非0为真，只有真true ，假false
	*/
	public static void main13(String[] args) {
		boolean flg = false;
		System.out.println(flg);//false
	}
}