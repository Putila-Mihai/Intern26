package betr.intern.task1.librarian;

import java.util.*;

public class Library {
    private final Map<Book, Integer> books;

    public Library() {
        books = new HashMap<Book, Integer>();
    }

    public Library(final HashMap<Book, Integer> books) {
        this.books = books;
    }

    public Map<Book, Integer> getBooks() {
        return books;
    }

    public Book getBookFromId(final UUID id) {
        return books.keySet()
                .stream()
                .filter(book -> books.keySet().contains(book))
                .findFirst()
                .orElseThrow();
    }

    public Book addBook(final Book book) {
        books.put(book, books.getOrDefault(book, 0) + 1);
        return book;
    }

    public Book removeBook(final UUID uuid) {
        final Optional<Book> book = Optional.of(books.containsKey(getBookFromId(uuid)) ? getBookFromId(uuid) : null);
        final Book bookToRemove = book.orElseThrow();
        books.remove(bookToRemove);
        return bookToRemove;
    }
}
