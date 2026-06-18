package betr.intern.Validators;

import betr.intern.Model.Item;

public class ItemValidate {
    public static void validate(Item item) {
        if (item == null)
            throw new RuntimeException("item is null");
        if (item.id() == null)
            throw new RuntimeException("item id is null");
        if (item.name() == null)
            throw new RuntimeException("item name is null");
        if (item.category() == null)
            throw new RuntimeException("item category is null");
        if (item.price() < 0)
            throw new RuntimeException("item price is negative");
    }
}
