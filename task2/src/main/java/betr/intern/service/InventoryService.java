package betr.intern.service;

import betr.intern.exception.DuplicateItemException;
import betr.intern.model.Category;
import betr.intern.model.Item;
import betr.intern.model.Stock;
import betr.intern.repository.CategoryRepository;
import betr.intern.repository.InventoryRepository;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final CategoryRepository categoryRepository;

    public InventoryService(InventoryRepository inventoryRepository, CategoryRepository categoryRepository) {
        this.inventoryRepository = inventoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public Item registerItem(Long id, String name, String details, double price, Category category, int initialStock) {
        if (inventoryRepository.findByItemId(id).isPresent()) {
            throw new DuplicateItemException("Produsul cu ID-ul " + id + " exista deja in inventar!");
        }

        Item item = new Item(id, name, details, price, category);
        Stock stock = new Stock(item, initialStock);
        inventoryRepository.save(stock);
        return item;
    }

    public void addStock(Item item, int amount) {
        Stock stock = inventoryRepository.findByItem(item)
                .orElseThrow(() -> new IllegalArgumentException("Produsul nu a fost gasit in inventar."));
        stock.addQuantity(amount);
    }

    public void assignCategory(Item item, Category category) {
        item.setCategory(category);
    }

    public void printItemsByCategory(Category category) {
        System.out.println("\n--- Produse in categoria: " + category.getName() + " ---");
        List<Stock> filtered = inventoryRepository.findAll().stream()
                .filter(stock -> stock.getItem().getCategory() != null && stock.getItem().getCategory().equals(category))
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("Nu exista produse in aceasta categorie.");
            return;
        }

        for (Stock stock : filtered) {
            System.out.println("- " + stock.getItem().getName() + " , Pret: " + stock.getItem().getPrice() + " RON , Stoc disponibil: " + stock.getQuantity());
        }
    }

    public void printFullInventory() {
        System.out.println("\n Inventar:");
        for (Stock stock : inventoryRepository.findAll()) {
            System.out.println("- " + stock.getItem().getName() + " [ID: " + stock.getItem().getId() + "] , Stoc: " + stock.getQuantity() + " buc. , Pret: " + stock.getItem().getPrice() + " RON");
        }
        System.out.println("-");
    }
}
