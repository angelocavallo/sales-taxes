
const TaxCalculator = function (configuration) {

    let _configuration = configuration

    function _isExempt(item) {
        const EXEMPT_CATEGPRIES = _configuration.EXEMPT_CATEGORIES;
        return EXEMPT_CATEGPRIES.includes(item.category);
    }

    function _getTax(item, taxRate) {
        let tmp = item.price * taxRate / 100;
        return Math.ceil(tmp / 5) * 5;
    }

    return {
        getBaseTax: (item) => {
            let result = 0;
            let taxRate = _configuration.BASE_TAX_PERC;
            if (!_isExempt(item)) {
                result = _getTax(item, taxRate);
            }
            return result;
        },
        getImportTax: (item) => {
            let result = 0;
            let taxRate = _configuration.IMPORT_TAX_PERC;
            if (item.imported) {
                result = result = _getTax(item, taxRate);;
            }
            return result;
        }
    }
}

module.exports = TaxCalculator;