package betr.intern.repository;

import betr.intern.model.Item;
import betr.intern.model.Stock;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InventoryRepository {

    private final Map<Long, Stock> inventory = new LinkedHashMap<>();

    public void save(Stock stock) {
        inventory.put(stock.getItem().getId(), stock);
    }

    public List<Stock> findAll() {
        return new ArrayList<>(inventory.values());
    }

    public Optional<Stock> findByItem(Item item) {
        if (item == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(inventory.get(item.getId()));
    }

    public Optional<Stock> findByItemId(Long itemId) {
        return Optional.ofNullable(inventory.get(itemId));
    }

    public void deleteByItem(Item item) {
        if (item != null) {
            inventory.remove(item.getId());
        }
    }
}
