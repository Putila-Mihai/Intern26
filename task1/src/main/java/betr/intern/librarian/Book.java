package betr.intern.librarian;

import java.util.Objects;
import java.util.UUID;

public record Book(UUID id, String isbn, String title, String author) {
    public Book(String isbn, String title, String author) {
        this(UUID.randomUUID(), isbn, title, author);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn(), book.isbn()) && Objects.equals(title(), book.title()) && Objects.equals(author(), book.author());
    }
}
