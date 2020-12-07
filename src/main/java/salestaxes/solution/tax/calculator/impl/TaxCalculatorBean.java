package salestaxes.solution.tax.calculator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import salestaxes.solution.model.ShoppingItem;
import salestaxes.solution.tax.calculator.TaxCalculator;
import salestaxes.solution.tax.services.TaxService;

@Component
public class TaxCalculatorBean implements TaxCalculator {

    @Value("${application.tax.rate.basic}")
    private int BASIC_TAX_RATE;

    @Value("${application.tax.rate.imported}")
    private int IMPORTED_TAX_RATE;

    @Autowired
    private TaxService taxService;

    @Override
    public int getTotalTaxes(ShoppingItem shoppingItem) {
        int total = 0;
        if (!taxService.isExempt(shoppingItem)) total += getBasicTax(shoppingItem);
        if (shoppingItem.isImported()) total += getImportTax(shoppingItem);
        return total;
    }

    private int getBasicTax(ShoppingItem shoppingItem) {
        return getTaxAmount(BASIC_TAX_RATE, shoppingItem);
    }

    private int getImportTax(ShoppingItem shoppingItem) {
        return getTaxAmount(IMPORTED_TAX_RATE, shoppingItem);
    }

    private int getTaxAmount(int rate, ShoppingItem shoppingItem) {
        int result = (rate * shoppingItem.getPrice()) / 100;
        return (int) Math.ceil((double) result / 5) * 5; //rounded up to the nearest 5
    }
}
