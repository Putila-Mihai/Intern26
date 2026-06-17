package betr.intern.librarian;

import java.util.UUID;

public class Book {
    private final UUID id;
    private final String isbn;
    private final String title;
    private final String author;

    public Book(final String isbn, final String title, final String author) {
        this.id = UUID.randomUUID();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
