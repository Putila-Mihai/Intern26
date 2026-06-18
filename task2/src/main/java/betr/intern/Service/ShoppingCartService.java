package betr.intern.Service;

import betr.intern.Model.Item;
import betr.intern.Model.ShoppingCart;
import betr.intern.Repos.BasicRepos.ShoppingCartRepo;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShoppingCartService {
    private final ShoppingCartRepo shoppingCartRepo;
    public ShoppingCartService() {
        shoppingCartRepo = new ShoppingCartRepo();
    }

    public void deleteShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepo.remove(shoppingCart);
    }

    public void addItemToShoppingCart(ShoppingCart shoppingCart, Item item) {
        try {
            ShoppingCart shoppingCartToAddItemIn = shoppingCartRepo.get(shoppingCart);

            // there should be a cleaner way to do this
            Map<Item, Integer> map = new HashMap<>(shoppingCartToAddItemIn.items());
            map.put(
                    item,
                    map.containsKey(item)
                            ? shoppingCartToAddItemIn.items().get(item) + 1
                            : 1
            );
            ShoppingCart shoppingCartToUpdate = shoppingCartToAddItemIn.
                    ofItems(shoppingCartToAddItemIn.id(), map)
                    .ofTotalPrice(shoppingCartToAddItemIn.id(), shoppingCartToAddItemIn.totalPrice() + item.price());

            shoppingCartRepo.update(shoppingCartToUpdate);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ShoppingCart createShoppingCartForUser() {
         return shoppingCartRepo.add(new ShoppingCart());
    }

    public void printShoppingCartWithPriceAndItems(ShoppingCart shoppingCart) {
        shoppingCartRepo.get(shoppingCart)
                .items()
                .forEach((key, value) -> System.out.format("Item: %s, Quantity: %d, price for %2$d of %1$s: %3$f%n", key.name(), value, value * key.price()));
        System.out.println("Total Price: " + shoppingCartRepo.get(shoppingCart).totalPrice().toString());
    }
}
