package book;

public class BookList {
    private Book[] books = new Book[10];
    private int usedSize;


    //构造方法，只要程序一运行就会有这三本书
    public BookList(){
        books[0] = new Book("三国演义", "罗贯中", 56, "小说");
        books[1] = new Book("西游记", "吴承恩", 76, "小说");
        books[2] = new Book("水浒传", "施耐庵", 96, "小说");
        this.usedSize = 3;

    }

    public void setBooks(int pos, Book book){
        this.books[pos] = book;

    }

    public Book getBook(int pos){
        return this.books[pos];
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
