package pl.coderslab.models;

public class Book {

    private static long FIRST_ID_AVAILABLE = 4L;
    private long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;

    public Book(){}

    public Book(long id, String isbn, String title, String author, String publisher, String type) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.type = type;
    }

    public static long getFirstIdAvailable() {
        return FIRST_ID_AVAILABLE++;
    }

    public static void setFirstIdAvailable(long firstIdAvailable) {
        FIRST_ID_AVAILABLE = firstIdAvailable;
    }

    public long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getType() {
        return type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
