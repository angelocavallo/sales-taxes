
const ReceiptBuilder = function(taxCalculator) {
    let _receipt = {};
    let _taxCalculator = taxCalculator;
    let _public = {
        addItem: (item) => {

            if (!_receipt.items) {
                _receipt.items = [];
            }

            let baseTax = _taxCalculator.getBaseTax(item);
            let importTax = _taxCalculator.getImportTax(item);
            let totalTax = baseTax + importTax;
            item.priceAfterTax = item.price + totalTax;

            if (!_receipt.salesTaxes && _receipt.salesTaxes !== 0) {
                _receipt.salesTaxes = 0;
            }
            _receipt.salesTaxes += totalTax * item.quantity;


            if (!_receipt.total && _receipt.total !== 0) {
                _receipt.total = 0;
            }
            _receipt.total += item.priceAfterTax * item.quantity;
            _receipt.items.push(item);
            return _public; //fluent interface
        },
        toString: () => {
            let items = _receipt.items;
            let lines = [];
            items.forEach(item => {
                let price = (item.priceAfterTax * item.quantity / 100).toFixed(2);
                let importedString = item.imported ? 'imported ' : '';
                let line = `${item.quantity} ${importedString + item.name}: ${price}`;
                lines.push(line);
            });
            let salesTaxes = (_receipt.salesTaxes / 100).toFixed(2);
            lines.push(`Sales Taxes: ${salesTaxes}`);

            let total = (_receipt.total / 100).toFixed(2);
            lines.push(`Total: ${total}`);
            return lines.join('\n');
        },
        build: () => _receipt
    };
    return _public;
}

module.exports = ReceiptBuilder;