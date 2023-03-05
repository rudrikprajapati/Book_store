package book;

import java.util.ArrayList;

public class BookHelper {

    // All Books Data
    ArrayList<Book> books = new ArrayList<Book>();

    public BookHelper() {
        books.add(new Book(1, 3, 110.11, "Doglapan", "Ashneer", Availability.IN_STORE));
        books.add(new Book(2, 2, 111, "How To Make Friends", "Dev", Availability.IN_STORE));
        books.add(new Book(3, 0, 99, "Naruto - Tale Of Ninja", "Ichiraku", Availability.OUT_OF_STOCK));
        books.add(new Book(4, 0, 99, "Kakashi - Tale Of Ninja", "Naruto", Availability.OUT_OF_STOCK));
        books.add(new Book(5, 0, 102.00, "Red - Tale Of Red Ranger", "Grum", Availability.OUT_OF_STOCK));
    }


    // Gets Specific Book
    public Book getSpecificBook(int index) {
        return books.get(index);
    }


    // Display All Books
    public void showBooks() {
        System.out.println("Book ID " + " | " + "Book Name" + " | " + "Book Points" + " | " + " Book Author " + " | " + "Book Availability " + " | " + "Book Copies Left");

        for (Book book : books) {
            System.out.println(book.getBook_id() + " | " + book.getName() + " | " + book.getPoints() + " | " + book.getAuthor() + " | " + book.getAvailability() + " | " + book.getCopies_left()
            );
        }
    }


    /// Getting Total Books Length
    public int getBooksLength() {
        return books.size();
    }

    // Decrease Book Copies After We Buy The Book
    public void decreaseBookCopies(int book_id) {
        if (books.get(book_id).getCopies_left() > 1) {
            books.get(book_id).setCopies_left();
        } else {
            books.get(book_id).setAvailability(Availability.OUT_OF_STOCK);
            books.get(book_id).setCopies_left();
        }
    }

}
