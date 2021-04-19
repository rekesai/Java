
class X{
    Y y = new Y();
    public X(){
        System.out.println("X");
    }
}
class Y{
    public Y(){
        System.out.println("Y");
    }
}
class A{
    public A(){
        System.out.println("A");
    }
}
class B extends A{
    public B(){
        System.out.println("B");
    }
}
class C extends B{
    public C(){
        System.out.println("C");
    }
}

/*super父类对象的引用
* super()显示调用父类的构造方法
* super.data;显示调用或访问成员变量
* super.fun()显示调用父类的方法
* this当前对象的引用
* this()
* this.data
* this.fun()
* */

class Student{
    public String name;
    public int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test0419 extends X {
    Y y = new Y();
    public Test0419(){
        System.out.println("Z");
    }
    public static void main(String[] args) {
        /*new Test0419();
        new X();*/
        /*A a1 = new A();
        A a2 = new B();
        A a3 = new C();*/
        Student student1 = new Student("zxc", 22);
        Student student2 = new Student("asd", 221);
        Student student3 = new Student("qwe", 223);
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
    }
}
