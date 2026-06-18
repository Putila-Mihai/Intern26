package betr.intern.Service;

import betr.intern.Model.Category;
import betr.intern.Model.Item;
import betr.intern.Repos.BasicRepos.ItemRepository;
import betr.intern.Repos.IRepository;

public class GigaService {
    private final IRepository<Item> repository;
    public GigaService() {
        this.repository = new ItemRepository();
    }
    public GigaService(IRepository<Item> repository) {
        this.repository = repository;
    }

    public void assignItemToCategory(Item item, Category category) {
        Item itemToAssignNewCategory = repository.get(item);
        Item newItem = new Item(itemToAssignNewCategory.id(),
                itemToAssignNewCategory.name(),
                itemToAssignNewCategory.details(),
                itemToAssignNewCategory.quantity(),
                category,
                itemToAssignNewCategory.price()
        );
        repository.update(newItem);
    }

    public void printListOfItemsGivenACategory(Category category) {
        repository.getAll().forEach(item -> {
            if (item.category().equals(category))
                System.out.println(item);
        });
    }

    public void addItemToStock(Item item) {
        try {
            repository.add(item);
        } catch (NullPointerException e) {
            System.out.format("addItemToStock: %s%n", e.getMessage());
        }
    }

    public void printAllItems() {
        repository.getAll().forEach(item -> {System.out.println(item.toString());});
    }
}
