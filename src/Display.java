import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display {
    static Scanner scanner = new Scanner(System.in);
    public static List<Book>booklist;

    public Display() { this.booklist = new ArrayList<>(); }

    public static void addBook(Book book) { booklist.add(book); }


    public Book getBook(String bookname) {
        for(Book book : booklist) {
            if(book.getbookname().equals(bookname)) {
                return book;
            }
        }
        return null;
    }
}
