package betr.intern.Model;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/***
 *  i do believe id and items are enough, totalPrice can be calculated at service level from the list
 *  and totalPrice changes often enough that there would be a lot of re-updating
 ***/

public record ShoppingCart(UUID id, Map<Item, Integer> items, Double totalPrice) {

    public ShoppingCart {
        Objects.requireNonNull(id, "ShoppingCart id cannot be null");
        Objects.requireNonNull(items, "ShoppingCart items cannot be null");
        Objects.requireNonNull(totalPrice, "ShoppingCart totalPrice cannot be null");
        if (totalPrice < 0) {
            throw new IllegalArgumentException("ShoppingCart totalPrice must be greater or equal than 0");
        }
    }

    public ShoppingCart() {
        this(UUID.randomUUID(), Map.of(), 0d);
    }

    public ShoppingCart(Map<Item, Integer> items, Double totalPrice) {
        this(UUID.randomUUID(), items, totalPrice);
    }

    public ShoppingCart ofTotalPrice(UUID keptId, Double totalPrice) {
        return new ShoppingCart(keptId, items, totalPrice);
    }

    public ShoppingCart ofItems(UUID keptId, Map<Item, Integer> items) {
        return new ShoppingCart(keptId, items, totalPrice);
    }
}
