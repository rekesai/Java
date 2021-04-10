class Student{
    //public 共有的
    //private一旦使用此修饰词 类外不可访问
    private String name;
    private int age;
    private String sex;
    //当属性变为私有的之后，一定要提供一些公开的set或get方法
/*
* 封装：使用关键字private来修饰成员变量时，统一提供对应的set和get方法，这样做的好处是，类的调用者对类的学习成本就降低了
* 静态方法里不能用this，this代表当前对象的引用
*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    //构造方法--只有调用完一个构造方法之后才会真正有一个对象
    public Student(){
        System.out.println("不带参数的构造方法执行了！");
    }
    public Student(String name){
        this.name = name;
        System.out.println("带1个参数的构造方法执行了！");
    }
    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}



public class Test {
    public static int arr(int[] array){
        int ret = 0;
        for (int i = 0; i < array.length; i++) {
            ret ^= array[i];
        }
        return ret;
    }
    public static void main(String[] args){
        /*Student student = new Student();//new的过程1、为对象开辟空间 2、调用构造方法
        Student student2 = new Student("zxc", 22, "男");//这里调用的其实就是构造方法
        System.out.println(student2);*/
        int[] array = {1,2,3,4,5,6,7,8,9,0};
        int[] array1 = {1,2,3,4,6,7,8,9,0};
        System.out.println(arr(array) ^ arr(array1));
    }
}
