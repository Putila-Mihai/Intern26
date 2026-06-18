package betr.intern.Repos.BasicRepos;

import betr.intern.Model.Item;
import betr.intern.Repos.IRepository;
import betr.intern.Validators.ItemValidate;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ItemRepository implements IRepository<Item> {
    Set<Item> items;

    public ItemRepository() {
        this.items = new HashSet<>();
    }

    @Override
    public Set<Item> getAll() {
        return items;
    }

    @Override
    public Item add(Item item) {
        try {
            ItemValidate.validate(item);
            if (!items.add(item))
                throw new RuntimeException("item already exists");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return item;
    }

    @Override
    public void remove(Item item) {
        try {
            Optional<Item> itemToRemove = Optional.ofNullable(this.get(Optional.of(item).stream().findFirst().orElseThrow()));
            ItemValidate.validate(itemToRemove.get());
            items.remove(itemToRemove.get());
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

    @Override
    public Item get(Item item) {
        return items.stream().filter(i -> i.id().equals(item.id())).findFirst().orElseThrow();
    }
}
