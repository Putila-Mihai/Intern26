package betr.intern.task2.Model;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public record Order(UUID id, OffsetDateTime datePurchased, Map<Item, Integer> items) {
    public Order {
        Objects.requireNonNull(datePurchased);
        Objects.requireNonNull(items);
    }

    public Order(final OffsetDateTime datePurchased, final Map<Item, Integer> items) {
        this(UUID.randomUUID(), datePurchased, items);
    }
}
