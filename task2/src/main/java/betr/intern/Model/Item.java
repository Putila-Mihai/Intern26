package betr.intern.Model;

import java.util.Objects;
import java.util.UUID;

public record Item(UUID id, String name, String details, Integer quantity, Category category, Double price) {
    public Item {
        Objects.requireNonNull(id, "id is null");
        Objects.requireNonNull(name, "name is null");
        Objects.requireNonNull(details, "details is null");
        Objects.requireNonNull(quantity, "quantity is null");
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity must be equal or greater than 0");
        }
        Objects.requireNonNull(category, "category is null");
        Objects.requireNonNull(price, "price is null");
        if (price < 0) {
            throw new IllegalArgumentException("price is negative");
        }
    }

    public Item(final String name, final String details, final Integer quantity, final Category category, final Double price) {
        this(UUID.randomUUID(), name, details, quantity, category, price);
    }

    public Item ofCategory(final UUID keptId, final Category category) {
        return new Item(keptId, name, details, quantity, category, price);
    }

    public Item ofName(final UUID keptId, final String name) {
        return new Item(keptId, name, details, quantity, category, price);
    }

    public Item ofDetails(final String details) {
        return new Item(UUID.randomUUID(), name, details, quantity, category, price);
    }

    public Item ofQuantity(final Integer quantity) {
        return new Item(UUID.randomUUID(), name, details, quantity, category, price);
    }

    //trying new things
    public static Item ofQuantityStatic(final Item item, final Integer quantity) {
        return new Item(item.id, item.name, item.details, quantity, item.category, item.price);
    }

    public Item ofPrice(final Double price) {
        return new Item(UUID.randomUUID(), name, details, quantity, category, price);
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof final Item item)) return false;
        return Objects.equals(name(), item.name()) && Objects.equals(details(), item.details()) && category() == item.category();
    }
}
