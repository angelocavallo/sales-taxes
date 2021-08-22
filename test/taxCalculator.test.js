var TaxCalculator = require('../public/javascripts/services/taxCalculator');
var configuration = require('./configuration.mock')
var assert = require('chai').assert;

describe('TaxCalculator', function () {

    let taxCalculator = new TaxCalculator(configuration)

    describe('#getBaseTax()', function () {
        it('should return the base tax amount', function () {
            let item = {
                name: 'dummy',
                price: 1000,
                category: 'house'
            }
            let taxAmount = taxCalculator.getBaseTax(item);
            assert.equal(taxAmount, 100);
        });

        it('should return 0 for exempt items', function () {
            let item = {
                name: 'dummy',
                price: 1000,
                category: 'book'
            }
            let taxAmount = taxCalculator.getBaseTax(item);
            assert.equal(taxAmount, 0);
        });

        it('should round the result to nearest 5', function () {
            let item = {
                name: 'dummy',
                price: 2799,
                category: 'internet'
            }
            let taxAmount = taxCalculator.getBaseTax(item);
            assert.equal(taxAmount, 280);
        });
    });

    describe('#getImportTax()', function () {
        it('should return the import tax amount', function () {
            let item = {
                name: 'dummy',
                price: 1000,
                category: 'house',
                imported: true
            }
            let taxAmount = taxCalculator.getImportTax(item);
            assert.equal(taxAmount, 50);
        });

        it('should return 0 for non imported items', function () {
            let item = {
                name: 'dummy',
                price: 1000,
                category: 'house'
            }
            let taxAmount = taxCalculator.getImportTax(item);
            assert.equal(taxAmount, 0);
        });

        it('should round the result to nearest 5', function () {
            let item = {
                name: 'dummy',
                price: 4376,
                category: 'internet',
                imported: true
            }
            let taxAmount = taxCalculator.getImportTax(item);
            assert.equal(taxAmount, 220);
        });
    });
});