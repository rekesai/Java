class Teacher{
    public String name;
    public Teacher(String name){
        this.name = name;
        System.out.println("我是"+name+"老师！");
    }
    public void checkHomeWork(Student studentName, HomeWork homeWork){
        System.out.println(this.name+"老师在批改"+studentName+"的"+homeWork+"作业！");
    }
}

class Student{
    public String name;
    public Student(String name){
        this.name = name;
        System.out.println("我是学生"+name+"!");
    }
    public void handInHomeWork(HomeWork homeWork){
        System.out.println("学生"+this.name+"交"+homeWork+"作业！");
    }
    @Override
    public String toString() {
        return name ;
    }
}

class HomeWork{
    public String subject;
    public HomeWork(String subject){
        this.subject = subject;
        System.out.println("我是"+this.subject+"作业!");
    }
    @Override
    public String toString() {
        return subject ;
    }
}

public class School {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("张三");
        Student s1 = new Student("李四");
        HomeWork math = new HomeWork("数学");
        s1.handInHomeWork(math);
        t1.checkHomeWork(s1,math);
    }
}
