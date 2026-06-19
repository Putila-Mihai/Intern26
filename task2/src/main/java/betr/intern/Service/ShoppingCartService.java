package betr.intern.Service;

import betr.intern.Model.Item;
import betr.intern.Model.ShoppingCart;
import betr.intern.Repos.BasicRepos.ShoppingCartRepo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShoppingCartService {
    private final ShoppingCartRepo shoppingCartRepo;
    public ShoppingCartService() {
        shoppingCartRepo = new ShoppingCartRepo();
    }

    public void deleteShoppingCart(final ShoppingCart shoppingCart) {
        shoppingCartRepo.remove(shoppingCart);
    }

    public void addItemToShoppingCart(final ShoppingCart shoppingCart, final Item item) {
        try {
            if (item.quantity() == 0) {
                System.out.println("Item out of stock");
                return;
            }

            final ShoppingCart shoppingCartToAddItemIn = shoppingCartRepo.find(shoppingCart).orElseThrow();
            final Map<Item, Integer> map = new HashMap<>(shoppingCartToAddItemIn.items());

            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
            final ShoppingCart shoppingCartToUpdate = shoppingCartToAddItemIn.
                    ofItems(shoppingCartToAddItemIn.id(), map)
                    .ofTotalPrice(shoppingCartToAddItemIn.id(), shoppingCartToAddItemIn.totalPrice() + item.price());

            shoppingCartRepo.update(shoppingCartToUpdate);
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /*
    maybe some day
    public void removeItemFromShoppingCart(final ShoppingCart shoppingCart, final Item item) {
        try {
            final ShoppingCart shoppingCartToAddItemIn = shoppingCartRepo.find(shoppingCart).orElseThrow();
            final Map<Item, Integer> map = new HashMap<>(shoppingCartToAddItemIn.items());

            if (map.containsKey(item) && map.get(item) > 0) {
                map.put(item, map.get(item) - 1);
            } else {
                System.out.println("how are we here");
            }
            final ShoppingCart shoppingCartToUpdate = shoppingCartToAddItemIn.
                    ofItems(shoppingCartToAddItemIn.id(), map)
                    .ofTotalPrice(shoppingCartToAddItemIn.id(), shoppingCartToAddItemIn.totalPrice() + item.price());

            shoppingCartRepo.update(shoppingCartToUpdate);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    */

    public ShoppingCart getShoppingCart(final ShoppingCart shoppingCart) {
        return shoppingCartRepo.find(shoppingCart).orElseThrow();
    }

    public ShoppingCart createShoppingCartForUser() {
         return shoppingCartRepo.add(new ShoppingCart());
    }

    public void printShoppingCartWithPriceAndItems(final ShoppingCart shoppingCart) {
        final ShoppingCart foundShoppingCart = shoppingCartRepo.find(shoppingCart).orElseThrow();
        foundShoppingCart.items()
                .forEach((key, value) -> System.out.format("Item: %s, Quantity: %d, price for %2$d of %1$s: %3$f%n", key.name(), value, value * key.price()));
        System.out.println("Total Price: " + foundShoppingCart.totalPrice().toString());
    }
}
