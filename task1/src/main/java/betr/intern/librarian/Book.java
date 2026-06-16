package betr.intern.librarian;

import java.util.UUID;

public class Book {
    private UUID uuid;
    private String title;
    private String author;

    public Book(String title, String author) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.author = author;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
