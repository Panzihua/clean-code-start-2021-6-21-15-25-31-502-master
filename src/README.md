Long method
printReceipt

unused annotation
author info and all annotation in OrderReceipt.java
// print headers
// print date, bill no, customer name
...

Naming:
private Order o;
StringBuilder output = new StringBuilder();
double totSalesTx = 0d;
double tot = 0d;

Wrong annotation, dead code
//Deprecated
public String printCustomerName() {
return o.getCustomerName();
}
//        output.append("Date - " + order.getDate();
//        output.append(order.getCustomerLoyaltyNumber());

Magical number
double totSalesTx = 0d;
double tot = 0d;
output.append('\t');
output.append('\n');
double salesTax = lineItem.totalAmount() * .10;
output.append("Sales Tax").append('\t').append(totSalesTx);
output.append("Total Amount").append('\t').append(tot);