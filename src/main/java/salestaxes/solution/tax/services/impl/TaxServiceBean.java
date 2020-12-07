package salestaxes.solution.tax.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import salestaxes.solution.model.ItemCategory;
import salestaxes.solution.model.ShoppingItem;
import salestaxes.solution.tax.services.TaxService;

import java.util.List;

@Service
public class TaxServiceBean implements TaxService {

    @Value("${application.tax.exemptCategories}")
    private List<ItemCategory> EXEMPT_CATEGORIES;


    @Override
    public boolean isExempt(ShoppingItem shoppingItem) {
        return EXEMPT_CATEGORIES.contains(shoppingItem.getCategory());
    }

}
