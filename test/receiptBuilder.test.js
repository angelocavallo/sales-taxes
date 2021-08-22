var TaxCalculator = require('../public/javascripts/services/taxCalculator');
var ReceiptBuilder = require('../public/javascripts/services/receiptBuilder');
var configuration = require('./configuration.mock')
var assert = require('chai').assert;

describe('ReceiptBuilder', function () {

    let taxCalculator = new TaxCalculator(configuration)

    describe('#addItem()', function () {
        it('should compute the tax amount', function () {
            let receiptBuilder = new ReceiptBuilder(taxCalculator);

            let item = {
                name: 'dummy',
                price: 1000,
                category: 'house',
                imported: true,
                quantity: 1
            }

            let item2 = {
                name: 'dummy',
                price: 2000,
                category: 'house',
                quantity: 1
            }

            receipt = receiptBuilder.addItem(item).addItem(item2).build();
            
            assert.equal(receipt.salesTaxes, 350);
        });

        it('should compute the total amount', function () {
            let receiptBuilder = new ReceiptBuilder(taxCalculator);

            let item = {
                name: 'dummy',
                price: 1000,
                category: 'house',
                imported: true,
                quantity: 1
            }

            let item2 = {
                name: 'dummy',
                price: 2000,
                category: 'house',
                quantity: 1
            }
            
            receipt = receiptBuilder.addItem(item).addItem(item2).build();
            
            let items = receipt.items;
            assert.equal(items.length, 2);
            assert.equal(items[0].priceAfterTax, 1150);
            assert.equal(items[1].priceAfterTax, 2200);
            assert.equal(receipt.total, 3350);
        });
    });
});