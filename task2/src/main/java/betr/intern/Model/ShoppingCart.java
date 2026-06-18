package betr.intern.Model;

import java.util.Map;
import java.util.UUID;

/***
 *  i do believe id and items are enough, totalPrice can be calculated at service level from the list
 *  and totalPrice changes often enough that there would be a lot of re-updating
 ***/

public record ShoppingCart(UUID id, Map<Item, Integer> items, Integer totalPrice) {
    public ShoppingCart(Map<Item, Integer> items, Integer totalPrice) {
        this(UUID.randomUUID(), items, totalPrice);
    }
}
