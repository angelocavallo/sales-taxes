package salestaxes.solution.receipt.factory.impl;

import salestaxes.solution.model.BasketEntry;
import salestaxes.solution.model.Receipt;
import salestaxes.solution.model.ReceiptEntry;
import salestaxes.solution.model.ShoppingBasket;
import salestaxes.solution.receipt.factory.ReceiptFactory;
import salestaxes.solution.tax.calculator.TaxCalculator;

import java.util.Set;
import java.util.stream.Collectors;

public class SimpleReceiptFactory implements ReceiptFactory {

    private final ShoppingBasket shoppingBasket;

    private final TaxCalculator taxCalculator;

    public SimpleReceiptFactory(ShoppingBasket shoppingBasket, TaxCalculator taxCalculator) {
        this.shoppingBasket = shoppingBasket;
        this.taxCalculator = taxCalculator;
    }

    @Override
    public Receipt getReceipt() {
        return new Receipt(
                getReceiptEntries(),
                getSalesTaxes(),
                getTotal()
        );
    }

    private Set<ReceiptEntry> getReceiptEntries() {
        return shoppingBasket.getEntries().stream().map(basketEntry -> new ReceiptEntry(
                basketEntry.getQuantity(),
                basketEntry.getShoppingItem().getDescription(),
                getFinalPrice(basketEntry))).collect(Collectors.toSet());
    }

    private int getSalesTaxes() {
        int salesTaxes = 0;
        for (BasketEntry basketEntry : shoppingBasket.getEntries()) {
            salesTaxes += getFinalTax(basketEntry);
        }
        return salesTaxes;
    }

    private int getTotal() {
        int total = 0;
        for (BasketEntry basketEntry : shoppingBasket.getEntries()) {
            total += getFinalPrice(basketEntry);
        }
        return total;
    }

    private int getFinalTax(BasketEntry entry) {
        return taxCalculator.getTotalTaxes(entry.getShoppingItem()) * entry.getQuantity();
    }

    private int getFinalPrice(BasketEntry entry) {
        return getFinalTax(entry) + entry.getShoppingItem().getPrice() * entry.getQuantity();
    }
}
