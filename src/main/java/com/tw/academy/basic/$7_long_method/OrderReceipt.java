package com.tw.academy.basic.$7_long_method;

import java.util.List;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    public static final double TAX_RATE_TEN_PERCENT = .10;
    public static final double ZORO_PRICE = 0d;
    private final Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    @Deprecated
    public String printCustomerName() {
        return order.getCustomerName();
    }

    //todo: rename -- Tom
    public String generateReceipt() {
        StringBuilder receiptContent = new StringBuilder();

        generateReceiptHeader(receiptContent);
        generateReceiptCustomerName(receiptContent);
        generateReceiptCustomerAddress(receiptContent);

        // prints lineItems
        double totSalesTx = calculateTotalPrice(order.getLineItems()) * TAX_RATE_TEN_PERCENT;
        double tot = calculateTotalPrice(order.getLineItems()) + totSalesTx;
        for (LineItem lineItem : order.getLineItems()) {
            generateReceiptBody(receiptContent, lineItem);
        }

        // prints the state tax
        receiptContent.append("Sales Tax").append('\t').append(totSalesTx);

        // print total amount
        receiptContent.append("Total Amount").append('\t').append(tot);
        return receiptContent.toString();
    }

    private static void generateReceiptHeader(StringBuilder receiptContent) {
        receiptContent.append("======Printing Orders======\n");
    }

    private void generateReceiptCustomerName(StringBuilder receiptContent) {
        receiptContent.append(order.getCustomerName());
    }

    private void generateReceiptCustomerAddress(StringBuilder receiptContent) {
        receiptContent.append(order.getCustomerAddress());
    }

    private void generateReceiptBody(StringBuilder receiptContent, LineItem lineItem) {
        receiptContent.append(lineItem.getDescription());
        receiptContent.append('\t');
        receiptContent.append(lineItem.getPrice());
        receiptContent.append('\t');
        receiptContent.append(lineItem.getQuantity());
        receiptContent.append('\t');
        receiptContent.append(lineItem.totalAmount());
        receiptContent.append('\n');
    }

    private static double calculateTotalPrice(List<LineItem> lineItemList) {
        return lineItemList.stream()
                .map(LineItem::totalAmount)
                .reduce(Double::sum)
                .orElse(ZORO_PRICE);
    }
}