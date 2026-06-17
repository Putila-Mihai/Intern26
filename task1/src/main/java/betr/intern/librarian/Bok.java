package betr.intern.librarian;

import java.util.Objects;
import java.util.UUID;

public record Bok(UUID id, String isbn, String title, String author) {
    public Bok(String isbn, String title, String author) {
        this(UUID.randomUUID(), isbn, title, author);
    }

    @Override
    public UUID id() {
        return id;
    }

    @Override
    public String isbn() {
        return isbn;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String author() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bok bok = (Bok) o;
        return Objects.equals(isbn(), bok.isbn()) && Objects.equals(title(), bok.title()) && Objects.equals(author(), bok.author());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id(), isbn(), title(), author());
    }

    @Override
    public String toString() {
        return "Bok{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
