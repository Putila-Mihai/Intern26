package betr.intern.task2.Service;

import betr.intern.task2.Model.Category;
import betr.intern.task2.Model.Item;
import betr.intern.task2.Repos.BasicRepos.ItemRepository;
import betr.intern.task2.Repos.IRepository;

public final class ItemService {
    private final ItemRepository repository;
    public ItemService() {
        this.repository = new ItemRepository();
    }
    public ItemService(final IRepository<Item> repository) {
        this.repository = (ItemRepository) repository;
    }

    // testing Optional type
    public Item getItem(final Item item) {
        return repository.find(item).orElseThrow();
    }

    public void assignItemToCategory(final Item item, final Category category) {
        final Item itemToAssignNewCategory = repository.find(item).orElseThrow();
        final Item newItem = itemToAssignNewCategory.ofCategory(itemToAssignNewCategory.id(), category);
        repository.update(newItem);
    }

    public void printListOfItemsGivenACategory(final Category category) {
        repository.getItemsByCategory(category).forEach(System.out::println);
    }

    public void addItemToStock(final Item item) {
        try {
            repository.add(item);
        } catch (final Exception e) {
            System.out.format("addItemToStock: %s%n", e.getMessage());
        }
    }

    public void printAllItems() {
        repository.getAll().forEach(item -> System.out.println(item.toString()));
    }

    public void updateItemQuantity(final Item item, final int quantity) {
        repository.update(Item.ofQuantityStatic(item, quantity));
    }
}
