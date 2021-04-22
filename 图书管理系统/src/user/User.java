package user;
import book.BookList;
import operation.IOperation;


public abstract class User {
    private String name;
    //准备一个接口数组 存储每个对象
    public IOperation[] iOperations;

    public User(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public abstract int menu();

    //3、
    public void doOperation(int choice, BookList bookList){
        this.iOperations[choice].work(bookList);
    }

}
