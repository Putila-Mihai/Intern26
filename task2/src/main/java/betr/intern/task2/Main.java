package betr.intern.task2;

import betr.intern.task2.Model.Category;
import betr.intern.task2.Model.Item;
import betr.intern.task2.Model.Order;
import betr.intern.task2.Model.ShoppingCart;
import betr.intern.task2.Service.Service;

import java.util.Optional;

public class Main {
    public static void main(final String[] args) {
        final Service service = new Service();
        final Item item1 = new Item("lol", "lmao", 3, Category.FOOD, 3.99);
        final Item item2 = new Item("asd", "qwe", 7, Category.QUESTIONABLE, 19.99);
        final Item item3 = new Item("woah", "wasson", 3, Category.OTHER, 233.99);

        //service.addItemToStock(null);
        service.addItemToStock(item1);
        service.addItemToStock(item2);
        service.addItemToStock(item3);
        service.printAllItems();

        System.out.println("Category assignment test");
        service.printListOfItemsGivenACategory(Category.QUESTIONABLE);
        service.assignItemToCategory(item1, Category.QUESTIONABLE);
        System.out.println("Item lol has been assigned category Questionable");
        service.printListOfItemsGivenACategory(Category.QUESTIONABLE);

        final ShoppingCart shoppingCart = service.createShoppingCartForUser();
        service.addItemToShoppingCart(shoppingCart, item1);
        service.addItemToShoppingCart(shoppingCart, item2);
        service.addItemToShoppingCart(shoppingCart, item1);
        service.addItemToShoppingCart(shoppingCart, item1);

        // the one below goes above available stock
        // service.addItemToShoppingCart(shoppingCart, item1);
        service.printShoppingCartWithPriceAndItems(shoppingCart);

        final Optional<Order> order = service.checkOut(shoppingCart);
    }
}