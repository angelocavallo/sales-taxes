package salestaxes.solution.model;

import java.util.Set;

public class Receipt {

    private Set<ReceiptEntry> entries;

    private int salesTaxes; //value expressed in cents

    private int total; //value expressed in cents

    public Receipt(Set<ReceiptEntry> entries, int salesTaxes, int total) {
        this.entries = entries;
        this.salesTaxes = salesTaxes;
        this.total = total;
    }

    public Set<ReceiptEntry> getEntries() {
        return entries;
    }

    public void setEntries(Set<ReceiptEntry> entries) {
        this.entries = entries;
    }

    public int getSalesTaxes() {
        return salesTaxes;
    }

    public void setSalesTaxes(int salesTaxes) {
        this.salesTaxes = salesTaxes;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
