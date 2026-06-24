package betr.intern;

import betr.intern.exception.OutOfStockException;
import betr.intern.exception.DuplicateItemException;
import betr.intern.model.Category;
import betr.intern.model.Item;
import betr.intern.model.ShoppingCart;
import betr.intern.model.Stock;
import betr.intern.repository.CategoryRepository;
import betr.intern.repository.InventoryRepository;
import betr.intern.repository.OrderRepository;
import betr.intern.service.CheckoutService;
import betr.intern.service.InventoryService;

public class Main {
    public static void main(String[] args) {
        InventoryRepository inventoryRepository = new InventoryRepository();
        CategoryRepository categoryRepository = new CategoryRepository();
        OrderRepository orderRepository = new OrderRepository();

        InventoryService inventoryService = new InventoryService(inventoryRepository, categoryRepository);
        CheckoutService checkoutService = new CheckoutService(inventoryRepository, orderRepository);

        Category electronics = categoryRepository.save(new Category(null, "Electronics"));
        Category books = categoryRepository.save(new Category(null, "Books"));

        Item laptop = inventoryService.registerItem(1L, "Laptop", "High performance laptop", 1200.00, electronics, 5);
        Item mouse = inventoryService.registerItem(2L, "Mouse", "Wireless mouse", 25.50, electronics, 10);
        Item novel = inventoryService.registerItem(3L, "Novel", "Fictional novel book", 15.00, books, 3);

        inventoryService.printFullInventory();

        inventoryService.printItemsByCategory(electronics);

        ShoppingCart cart = new ShoppingCart();

        Stock laptopStock = inventoryRepository.findByItem(laptop).orElseThrow();
        Stock mouseStock = inventoryRepository.findByItem(mouse).orElseThrow();
        Stock novelStock = inventoryRepository.findByItem(novel).orElseThrow();

        cart.addItem(laptop, 2, laptopStock);
        cart.addItem(mouse, 3, mouseStock);

        cart.printCart();

        try {
            cart.addItem(laptop, 4, laptopStock);
        } catch (OutOfStockException e) {
            System.out.println("\n[Avertisment Stoc] Nu s-a putut adauga produsul: " + e.getMessage());
        }

        try {
            inventoryService.registerItem(1L, "Alt Laptop", "Spec", 100.0, electronics, 1);
        } catch (DuplicateItemException e) {
            System.out.println("[Alerta Catalog] Inregistrare esuata: " + e.getMessage());
        }

        checkoutService.checkout(cart);

        inventoryService.printFullInventory();
    }
}