package salestaxes.solution.model;

public class BasketEntry {

    private int quantity;

    private ShoppingItem shoppingItem;

    public BasketEntry(int quantity, ShoppingItem shoppingItem) {
        this.quantity = quantity;
        this.shoppingItem = shoppingItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ShoppingItem getShoppingItem() {
        return shoppingItem;
    }

    public void setShoppingItem(ShoppingItem shoppingItem) {
        this.shoppingItem = shoppingItem;
    }
}
