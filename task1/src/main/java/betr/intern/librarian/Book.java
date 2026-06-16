package betr.intern.librarian;

import java.util.UUID;

public class Book {
    private final UUID uuid;
    private final String title;
    private final String author;

    public Book(final String title, final String author) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.author = author;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
