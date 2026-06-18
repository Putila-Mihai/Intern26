package betr.intern;

import betr.intern.Model.Category;
import betr.intern.Model.Item;
import betr.intern.Model.Order;
import betr.intern.Model.ShoppingCart;
import betr.intern.Service.ItemService;
import betr.intern.Service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Item item1 = new Item("lol", "lmao", 3, Category.FOOD, 3.99);
        Item item2 = new Item("asd", "qwe", 7, Category.QUESTIONABLE, 19.99);
        Item item3 = new Item("woah", "wasson", 3, Category.OTHER, 233.99);

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

        ShoppingCart shoppingCart = service.CreateShoppingCartForUser();
        service.addItemToShoppingCart(shoppingCart, item1);
        service.addItemToShoppingCart(shoppingCart, item2);
        service.addItemToShoppingCart(shoppingCart, item1);
        service.addItemToShoppingCart(shoppingCart, item1);
        service.printShoppingCartWithPriceAndItems(shoppingCart);

        Order order = service.Checkout(shoppingCart);
        service.printOrderDetails(order);
    }
}