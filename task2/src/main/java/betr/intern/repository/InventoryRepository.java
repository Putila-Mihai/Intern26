package betr.intern.repository;

import betr.intern.model.Item;
import betr.intern.model.Stock;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryRepository {

    private final List<Stock> inventory = new ArrayList<>();

    public void save(Stock stock) {
        deleteByItem(stock.getItem());
        inventory.add(stock);
    }

    public List<Stock> findAll() {
        return new ArrayList<>(inventory);
    }

    public Optional<Stock> findByItem(Item item) {
        return inventory.stream()
                .filter(s -> s.getItem().equals(item))
                .findFirst();
    }

    public Optional<Stock> findByItemId(Long itemId) {
        return inventory.stream()
                .filter(s -> s.getItem().getId().equals(itemId))
                .findFirst();
    }

    public void deleteByItem(Item item) {
        inventory.removeIf(s -> s.getItem().equals(item));
    }
}
