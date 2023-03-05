package book;

public class Book {
    private final int book_id;
    private int copies_left;
    private final double points;
    private final String name;
    private final String author;
    private Availability availability;

    // Constructor For Book Class
    public Book(int book_id, int copies_left, double price, String name, String author, Availability availability) {
        this.book_id = book_id;
        this.copies_left = copies_left;
        this.points = price;
        this.name = name;
        this.author = author;
        this.availability = availability;
    }

    // Get - Book ID
    public int getBook_id() {
        return book_id;
    }

    //Decreasing Book Copies
    public void setCopies_left() {
        --copies_left;
    }

    /// Getting Book Copies Left Length
    public int getCopies_left() {
        return copies_left;
    }


    // Get - Book Price
    public double getPoints() {
        return points;
    }

    // Get - Book Name
    public String getName() {
        return name;
    }

    // Get - Book Author
    public String getAuthor() {
        return author;
    }

    // Get - Book Availability
    public Availability getAvailability() {
        return availability;
    }

    //Set - Setting Book Availability
    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}
