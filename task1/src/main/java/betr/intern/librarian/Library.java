package betr.intern.librarian;

import java.util.*;

public class Library {
    private final Map<Bok, Integer> books;

    public Library() {
        books = new HashMap<Bok, Integer>();
    }

    public Library(HashMap<Bok, Integer> books) {
        this.books = books;
    }

    public Map<Bok, Integer> getBooks() {
        return books;
    }

    public Bok getBookFromId(UUID id) {
        Optional<Bok> lebook = Optional.ofNullable(
                books.keySet()
                        .stream()
                        .filter(
                                book -> book.id().equals(id)
                        )
                        .findFirst()
                        .orElse(null)
        );
        return lebook.get();
    }

    public Bok addBook(Bok book) {
        books.put(book, books.getOrDefault(book, 0) + 1);
        return book;
    }

    public Bok removeBook(UUID uuid) {
        Optional<Bok> book = Optional.of(books.containsKey(getBookFromId(uuid)) ? getBookFromId(uuid) : null);
        Bok bookToRemove = book.orElseThrow();
        books.remove(bookToRemove);
        return bookToRemove;
    }
}
