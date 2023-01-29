public class Book {
        public static String bookname;
        public static Integer bookprice;
        public static Integer quantity;

        public Book(String bookname, Integer bookprice, Integer quantity)
        {
            this.bookname = bookname;
            this.bookprice = bookprice;
            this.quantity = quantity;
        }

    public String getbookname() { return bookname; }
}
