package salestaxes.solution.model;

public class ReceiptEntry {

    private int quantity;

    private String description;

    private int price;

    public ReceiptEntry(int quantity, String description, int price) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
}
