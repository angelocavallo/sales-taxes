package salestaxes.solution.tax.services;

import salestaxes.solution.model.ShoppingItem;

public interface TaxService {

    boolean isExempt(ShoppingItem shoppingItem);

}
