package betr.intern;

import betr.intern.Model.Category;
import betr.intern.Model.Item;
import betr.intern.Model.Order;
import betr.intern.Service.GigaService;

public class Main {
    public static void main(String[] args) {
        GigaService gigaService = new GigaService();
        Item item1 = new Item("lol", "lmao", 3, Category.FOOD, 3.99);
        Item item2 = new Item("asd", "qwe", 7, Category.QUESTIONABLE, 19.99);
        Item item3 = new Item("woah", "wasson", 3, Category.OTHER, 233.99);
        gigaService.addItemToStock(null);
        gigaService.addItemToStock(item1);
        gigaService.addItemToStock(item2);
        gigaService.addItemToStock(item3);
        gigaService.printAllItems();
        System.out.println("Category assignment test");
        gigaService.printListOfItemsGivenACategory(Category.QUESTIONABLE);
        gigaService.assignItemToCategory(item1, Category.QUESTIONABLE);
        System.out.println("Item lol has been assigned category Questionable");
        gigaService.printListOfItemsGivenACategory(Category.QUESTIONABLE);
    }
}