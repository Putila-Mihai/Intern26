package betr.intern.Model;

import java.util.Objects;
import java.util.UUID;

public record Item(UUID id, String name, String details, Integer quantity, Category category, Double price) {
    public Item {
        Objects.requireNonNull(id, "id is null");
        Objects.requireNonNull(name, "name is null");
        Objects.requireNonNull(details, "details is null");
        Objects.requireNonNull(quantity, "quantity is null");
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be greater than 0");
        }
        Objects.requireNonNull(category, "category is null");
        Objects.requireNonNull(price, "price is null");
        if (price < 0) {
            throw new IllegalArgumentException("price is negative");
        }
    }

    public Item(String name, String details, Integer quantity, Category category, Double price) {
        this(UUID.randomUUID(), name, details, quantity, category, price);
    }

    public Item ofCategory(UUID keptId, Category category) {
        return new Item(keptId, name, details, quantity, category, price);
    }

    public Item ofName(UUID keptId, String name) {
        return new Item(keptId, name, details, quantity, category, price);
    }

    public Item ofDetails(String details) {
        return new Item(UUID.randomUUID(), name, details, quantity, category, price);
    }

    public Item ofQuantity(Integer quantity) {
        return new Item(UUID.randomUUID(), name, details, quantity, category, price);
    }

    public Item ofPrice(Double price) {
        return new Item(UUID.randomUUID(), name, details, quantity, category, price);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item item)) return false;
        return Objects.equals(name(), item.name()) && Objects.equals(details(), item.details()) && category() == item.category();
    }
}
