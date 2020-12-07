package salestaxes.solution.model;

public class ShoppingItem {

    private String description;

    private int price; // value expressed in cents.

    private ItemCategory category;

    public ShoppingItem(String description, int price, ItemCategory category) {
        this.description = description;
        this.price = price;
        this.category = category;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isImported() {
        return description.toLowerCase().contains("imported"); // assuming that descriptions always follow this rules, otherwise set a boolean flag.
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }
}
