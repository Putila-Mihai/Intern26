package betr.intern.Model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record Order(UUID id, LocalDateTime datePurchased, List<Item> items) {
    public Order(LocalDateTime datePurchased, List<Item> items) {
        this(UUID.randomUUID(), datePurchased, items);
    }
}
