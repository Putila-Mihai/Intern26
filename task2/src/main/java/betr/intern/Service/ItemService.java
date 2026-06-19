package betr.intern.Service;

import betr.intern.Model.Category;
import betr.intern.Model.Item;
import betr.intern.Repos.BasicRepos.ItemRepository;
import betr.intern.Repos.IRepository;

public final class ItemService {
    private final ItemRepository repository;
    public ItemService() {
        this.repository = new ItemRepository();
    }
    public ItemService(IRepository<Item> repository) {
        this.repository = (ItemRepository) repository;
    }

    public Item getItem(Item item) {
        return repository.get(item);
    }

    public void assignItemToCategory(Item item, Category category) {
        Item itemToAssignNewCategory = repository.get(item);
        Item newItem = itemToAssignNewCategory.ofCategory(itemToAssignNewCategory.id(), category);
        repository.update(newItem);
    }

    public void printListOfItemsGivenACategory(Category category) {
        repository.getItemsByCategory(category).forEach(System.out::println);
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

    public void updateItemQuantity(Item item, int quantity) {
        Item itemToUpdate = repository.get(item).ofQuantity(quantity);
        repository.update(itemToUpdate);
    }
}
