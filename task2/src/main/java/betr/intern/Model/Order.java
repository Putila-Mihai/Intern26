package betr.intern.Model;

import java.time.OffsetDateTime;
import java.util.List;
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
