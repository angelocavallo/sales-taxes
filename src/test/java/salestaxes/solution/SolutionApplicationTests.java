package salestaxes.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import salestaxes.solution.model.ItemCategory;
import salestaxes.solution.model.Receipt;
import salestaxes.solution.model.ShoppingBasket;
import salestaxes.solution.model.ShoppingItem;
import salestaxes.solution.receipt.factory.ReceiptFactory;
import salestaxes.solution.receipt.factory.impl.SimpleReceiptFactory;
import salestaxes.solution.tax.calculator.TaxCalculator;

@SpringBootTest
class SolutionApplicationTests {

    @Autowired
    private TaxCalculator taxCalculator;

    @Test
    void testReceiptInput1() {

        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket
                .addShoppingItem(
                        1,
                        new ShoppingItem(
                                "book",
                                1249,
                                ItemCategory.BOOK
                        ))
                .addShoppingItem(
                        1,
                        new ShoppingItem(
                                "music CD",
                                1499,
                                ItemCategory.OTHER
                        )
                )
                .addShoppingItem(
                        1,
                        new ShoppingItem(
                                "chocolate bar",
                                85,
                                ItemCategory.FOOD
                        )
                );

        ReceiptFactory receiptFactory = new SimpleReceiptFactory(shoppingBasket, taxCalculator);

        Receipt receipt = receiptFactory.getReceipt();

        Assertions.assertNotNull(receipt);
        Assertions.assertEquals(150, receipt.getSalesTaxes());
        Assertions.assertEquals(2983, receipt.getTotal());
    }

    @Test
    void testReceiptInput2() {

        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket
                .addShoppingItem(
                        1,
                        new ShoppingItem(
                                "imported box of chocolates",
                                1000,
                                ItemCategory.FOOD
                        ))
                .addShoppingItem(
                        1,
                        new ShoppingItem(
                                "imported bottle of perfume",
                                4750,
                                ItemCategory.OTHER
                        )
                );

        ReceiptFactory receiptFactory = new SimpleReceiptFactory(shoppingBasket, taxCalculator);

        Receipt receipt = receiptFactory.getReceipt();

        Assertions.assertNotNull(receipt);
        Assertions.assertEquals(765, receipt.getSalesTaxes());
        Assertions.assertEquals(6515, receipt.getTotal());
    }

    @Test
    void testReceiptInput3() {

        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket
                .addShoppingItem(
                        1,
                        new ShoppingItem(
                                "imported bottle of perfume",
                                2799,
                                ItemCategory.OTHER
                        ))
                .addShoppingItem(
                        1,
                        new ShoppingItem(
                                "bottle of perfume",
                                1899,
                                ItemCategory.OTHER
                        ))
                .addShoppingItem(
                        1,
                        new ShoppingItem(
                                "packet of headache pills",
                                975,
                                ItemCategory.MEDICAL
                        ))
                .addShoppingItem(
                        1,
                        new ShoppingItem(
                                "box of imported chocolates",
                                1125,
                                ItemCategory.FOOD
                        )
                );


        ReceiptFactory receiptFactory = new SimpleReceiptFactory(shoppingBasket, taxCalculator);

        Receipt receipt = receiptFactory.getReceipt();

        Assertions.assertNotNull(receipt);
        Assertions.assertEquals(670, receipt.getSalesTaxes());
        Assertions.assertEquals(7468, receipt.getTotal());
    }

}
