package betr.intern;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public void removeByTitle(String title){
        books.removeIf(book->book.getTitle().equalsIgnoreCase(title));
    }

    public void displayBooks(){
        if(books.isEmpty()){
            System.out.println("Nu avem carti in librarie!");
        }else{
            System.out.println("Acestea sunt cartile pe care le avem:");
            {
                for(Book book:books){
                    System.out.println("Carte: " + book);
                }
            }
        }
    }
}
