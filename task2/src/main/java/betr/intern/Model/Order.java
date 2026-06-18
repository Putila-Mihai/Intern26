package betr.intern.Model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public record Order(UUID id, LocalDateTime datePurchased, Map<Item, Integer> items) {
    public Order {
        Objects.requireNonNull(datePurchased);
        Objects.requireNonNull(items);
    }

    public Order(LocalDateTime datePurchased, Map<Item, Integer> items) {
        this(UUID.randomUUID(), datePurchased, items);
    }
}
