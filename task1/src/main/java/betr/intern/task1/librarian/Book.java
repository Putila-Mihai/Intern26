package betr.intern.task1.librarian;

import java.util.Objects;
import java.util.UUID;

public record Book(UUID id, String isbn, String title, String author) {
    public Book(final String isbn, final String title, final String author) {
        this(UUID.randomUUID(), isbn, title, author);
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final Book book = (Book) o;
        return Objects.equals(isbn(), book.isbn()) && Objects.equals(title(), book.title()) && Objects.equals(author(), book.author());
    }
}
