package betr.intern.librarian;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class Library {
    private final Collection<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }
    public Library(Collection<Book> books) {
        this.books = books;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public Book removeBook(UUID uuid) {
        Optional<Book> book = books.stream().filter(b -> b.getUuid().equals(uuid)).findFirst();
        Book bookToRemove = book.orElseThrow();
        books.remove(bookToRemove);
        return bookToRemove;
    }
}
