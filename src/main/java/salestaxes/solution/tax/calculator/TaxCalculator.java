package salestaxes.solution.tax.calculator;

import salestaxes.solution.model.ShoppingItem;

public interface TaxCalculator {

    int getTotalTaxes(ShoppingItem shoppingItem);
}
