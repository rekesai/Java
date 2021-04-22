import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;
import java.util.Scanner;

public class Main {
    public static User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入姓名： ");
        String name = scanner.nextLine();
        System.out.println("请输入您的身份：1.管理员 0.普通用户");
        int choice = scanner.nextInt();
        if(choice == 1){//向上转型
            return new AdminUser(name);
        }
        else{
            return new NormalUser(name);
        }

    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        //根据登录来判断登录的是管理员还是普通用户
        User user = login();
        //根据登录来判断调用谁的菜单
        int choice = user.menu();
        //根据登录来判断调用谁的对象
        user.doOperation(choice, bookList);

    }
}
