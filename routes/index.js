var express = require('express');
const TaxCalculator = require('../public/javascripts/services/taxCalculator');
const configuration = require('../public/javascripts/configuration');
const ReceiptBuilder = require('../public/javascripts/services/receiptBuilder');
var router = express.Router();

/* Purchase items */
router.post('/purchase', function(req, res, next) {
  let items = req.body.items;
  let taxCalculator = new TaxCalculator(configuration);
  let receiptBuilder = new ReceiptBuilder(taxCalculator);
  items.forEach(item => {
    receiptBuilder.addItem(item);
  });
  let receipt = receiptBuilder.toString();
  res.send(receipt);
});

module.exports = router;
