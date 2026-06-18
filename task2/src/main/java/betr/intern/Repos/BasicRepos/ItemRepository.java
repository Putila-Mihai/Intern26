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
     * Add operation for items
     * Returns an Item object that is to be added in the repository
     *
     * @param item an item that is to be added in the repository
     * @throws RuntimeException if the item already exists
     * @return
     */
    @Override
    public Item add(Item item) {
        try {
            if (items.contains(item))
                throw new RuntimeException("item already exists");
            if (item.equals(null))
                throw new NullPointerException("item is null");
            items.add(item);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public void remove(Item item) {
        try {
            Item itemToRemove = this.get(Optional.of(item).stream().findFirst().orElseThrow());
            items.remove(itemToRemove);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /***
        for immutability, updating means removing the previous object
        and adding a new object with the new properties. not using a framework *yet*
     ***/
    @Override
    public Item update(Item item) {
        try {
            Item itemToRemove = items.stream()
                    .filter(i -> i.id().equals(item.id()))
                    .findFirst()
                    .orElseThrow();
            remove(itemToRemove);
            add(item);
        } catch (Exception e) {
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
    public Item get(Item item) {
        return items.stream().filter(i -> i.id().equals(item.id())).findFirst().orElseThrow();
    }

    public Set<Item> getItemsByCategory(Category category) {
        return items.stream().filter(item -> item.category().equals(category)).collect(Collectors.toSet());
    }
}
