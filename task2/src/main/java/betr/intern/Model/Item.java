package betr.intern.Model;

import java.util.UUID;

public record Item(UUID id, String name, String details, Integer quantity, Category category, Double price) {
    public Item(String name, String details, Integer quantity, Category category, Double price) {
        this(UUID.randomUUID(), name, details, quantity, category, price);
    }
}
