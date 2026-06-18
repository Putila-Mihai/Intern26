package betr.intern.Service;

import betr.intern.Model.Category;
import betr.intern.Model.Item;
import betr.intern.Model.Order;
import betr.intern.Model.ShoppingCart;

public class Service {
    private final ItemService itemService = new ItemService();
    private final OrderService orderService = new OrderService();
    private final ShoppingCartService shoppingCartService = new ShoppingCartService();

    public void assignItemToCategory(Item item, Category category) {
        itemService.assignItemToCategory(item, category);
    }

    public void printListOfItemsGivenACategory(Category category) {
        itemService.printListOfItemsGivenACategory(category);
    }

    public void addItemToStock(Item item) {
        itemService.addItemToStock(item);
    }

    public void printAllItems() {
        itemService.printAllItems();
    }

    public ShoppingCart CreateShoppingCartForUser() {
        return shoppingCartService.createShoppingCartForUser();
    }

    public void addItemToShoppingCart(ShoppingCart shoppingCart, Item item) {
        shoppingCartService.addItemToShoppingCart(shoppingCart, item);
    }

    public void printShoppingCartWithPriceAndItems(ShoppingCart shoppingCart) {
        shoppingCartService.printShoppingCartWithPriceAndItems(shoppingCart);
    }

    public Order Checkout(ShoppingCart shoppingCart) {
        Order order = orderService.addOrder(shoppingCart);
        shoppingCart.items()
                .forEach(
                        (key, value) -> itemService.updateItemQuantity(
                                key,
                                itemService.getItem(key).quantity() - value
                        ));
        shoppingCartService.deleteShoppingCart(shoppingCart);
        return order;
    }
    public void printOrderDetails(Order order) {
        orderService.printOrderDetails(order);
    }
}
