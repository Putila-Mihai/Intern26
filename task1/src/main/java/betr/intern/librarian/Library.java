package betr.intern.librarian;

import java.util.*;

public class Library {
    private final Map<Book, Integer> books;

    public Library() {
        books = new HashMap<Book, Integer>();
    }

    public Library(HashMap<Book, Integer> books) {
        this.books = books;
    }

    public Map<Book, Integer> getBooks() {
        return books;
    }

    public Book getBookFromId(UUID id) {
        return books.keySet()
                .stream()
                .filter(book -> books.keySet().contains(book))
                .findFirst()
                .orElseThrow();
    }

    public Book addBook(Book book) {
        books.put(book, books.getOrDefault(book, 0) + 1);
        return book;
    }

    public Book removeBook(UUID uuid) {
        Optional<Book> book = Optional.of(books.containsKey(getBookFromId(uuid)) ? getBookFromId(uuid) : null);
        Book bookToRemove = book.orElseThrow();
        books.remove(bookToRemove);
        return bookToRemove;
    }
}
