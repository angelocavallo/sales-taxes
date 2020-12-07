package salestaxes.solution.model;

import java.util.HashSet;
import java.util.Set;

public class ShoppingBasket {

    private final Set<BasketEntry> entries = new HashSet<>();

    public Set<BasketEntry> getEntries() {
        return entries;
    }

    public ShoppingBasket addShoppingItem(int quantity, ShoppingItem shoppingItem) {
        entries.add(new BasketEntry(quantity, shoppingItem));
        return this;
    }

    public ShoppingBasket addEntry(BasketEntry entry) {
        entries.add(entry);
        return this;
    }

    public ShoppingBasket addEntries(Set<BasketEntry> entries) {
        this.entries.addAll(entries);
        return this;
    }
}
