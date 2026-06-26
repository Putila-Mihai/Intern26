package betr.intern.task2.Service;

import betr.intern.task2.Model.Category;
import betr.intern.task2.Model.Item;
import betr.intern.task2.Model.Order;
import betr.intern.task2.Model.ShoppingCart;

import java.util.Optional;

public class Service {
    private static final ItemService itemService = new ItemService();
    private static final OrderService orderService = new OrderService();
    private static final ShoppingCartService shoppingCartService = new ShoppingCartService();

    public void assignItemToCategory(final Item item, final Category category) {
        itemService.assignItemToCategory(item, category);
    }

    public void printListOfItemsGivenACategory(final Category category) {
        itemService.printListOfItemsGivenACategory(category);
    }

    public void addItemToStock(final Item item) {
        itemService.addItemToStock(item);
    }

    public void printAllItems() {
        itemService.printAllItems();
    }

    public ShoppingCart createShoppingCartForUser() {
        return shoppingCartService.createShoppingCartForUser();
    }

    public void addItemToShoppingCart(final ShoppingCart shoppingCart, final Item item) {
        shoppingCartService.addItemToShoppingCart(shoppingCart, item);
    }



    public void printShoppingCartWithPriceAndItems(final ShoppingCart shoppingCart) {
        shoppingCartService.printShoppingCartWithPriceAndItems(shoppingCart);
    }

    public boolean checkIfItemsWithCartQuantityGreaterThanAvailableStock(final ShoppingCart shoppingCart) {
        final ShoppingCart foundShoppingCart = shoppingCartService.getShoppingCart(shoppingCart);

        return foundShoppingCart.items().entrySet().stream()
                .filter(entry -> entry.getValue() > entry.getKey().quantity())
                .peek(entry -> System.out.format(
                        "You are attempting to purchase %d copies of %s, but only %d are in stock.%n",
                        entry.getValue(),
                        entry.getKey().name(),
                        entry.getKey().quantity()
                ))
                .findAny()
                .isPresent();
    }

    public Optional<Order> checkOut(final ShoppingCart shoppingCart) {
        final ShoppingCart foundShoppingCart = shoppingCartService.getShoppingCart(shoppingCart);
        if (checkIfItemsWithCartQuantityGreaterThanAvailableStock(foundShoppingCart)) {
            return Optional.empty();
        } else {
            final Order order = orderService.addOrder(foundShoppingCart);
            foundShoppingCart.items().forEach((key, value) ->
            {
                final int newItemQuantity = itemService.getItem(key).quantity();
                itemService.updateItemQuantity(key, newItemQuantity - value);
            });
            shoppingCartService.deleteShoppingCart(foundShoppingCart);
            printOrderDetails(order);
            return Optional.of(order);
        }
    }
    public void printOrderDetails(final Order order) {
        orderService.printOrderDetails(order);
    }
}
