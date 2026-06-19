package betr.intern.Repos.BasicRepos;

import betr.intern.Model.Category;
import betr.intern.Model.Item;
import betr.intern.Repos.IRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemRepository implements IRepository<Item> {
    Set<Item> items;

    public ItemRepository() {
        this.items = new HashSet<>();
    }

    @Override
    public Set<Item> getAll() {
        return items;
    }

    /**
     * Add operation for items.
     * Returns an Item object that is to be added in the repository.
     * Will use find to get an Optional of item, check if it is present, return if it is, throw if not
     *
     * @param item an item that is to be added in the repository
     * @throws RuntimeException if the item already exists
     * @return item to be added
     */
    @Override
    public Item add(final Item item) throws RuntimeException {
        if (find(item).isPresent()) {
            throw new RuntimeException("item already exists");
        }
        items.add(item);
        return item;
    }

    @Override
    public void remove(final Item item) {
        find(item).ifPresentOrElse(items::remove, () -> {
            throw new RuntimeException("Item to be removed not found");
        });
    }

    /***
        for immutability, updating means removing the previous object
        and adding a new object with the new properties. not using a framework *yet*
     ***/
    @Override
    public Item update(final Item item) {
        try {
            remove(item);
            add(item);
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
        return item;
    }

   /* public Item updateQuantityOfAnItem(Item item, int quantity) {
        remove(item);
        Item itemUpdated = add(item.ofQuantity(quantity));
        return itemUpdated;
    }

    public Item updatePriceOfAnItem(Item item, double price) {
        return item.ofPrice(price);
    }*/

    @Override
    public Optional<Item> find(final Item item) {
        return items.stream().filter(i -> i.id().equals(item.id())).findFirst();
    }

    public Set<Item> getItemsByCategory(final Category category) {
        return items.stream().filter(item -> item.category().equals(category)).collect(Collectors.toSet());
    }
}
