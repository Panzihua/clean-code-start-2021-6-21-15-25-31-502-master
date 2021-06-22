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

    public String generateReceipt() {
        return generateReceiptBody(generateReceiptHeader(), order.getLineItems());
    }

    private void generateReceiptSalesTax(StringBuilder receiptContent, double totSalesTx) {
        receiptContent.append("Sales Tax").append('\t').append(totSalesTx);
    }

    private void generateReceiptTotalAmount(StringBuilder receiptContent, double totalAmount) {
        receiptContent.append("Total Amount").append('\t').append(totalAmount);
    }

    private StringBuilder generateReceiptHeader() {
        StringBuilder receiptContent = new StringBuilder();
        receiptContent.append("======Printing Orders======\n");
        generateReceiptCustomerName(receiptContent);
        return generateReceiptCustomerAddress(receiptContent);
    }

    private void generateReceiptCustomerName(StringBuilder receiptContent) {
        receiptContent.append(order.getCustomerName());
    }

    private StringBuilder generateReceiptCustomerAddress(StringBuilder receiptContent) {
        return receiptContent.append(order.getCustomerAddress());
    }

    private String generateReceiptBody(StringBuilder header, List<LineItem> lineItemList) {
        lineItemList
                .forEach(lineItem ->
                        header.append(lineItem.getDescription())
                        .append('\t')
                        .append(lineItem.getPrice())
                        .append('\t')
                        .append(lineItem.getQuantity())
                        .append('\t')
                        .append(lineItem.totalAmount())
                        .append('\n'));

        generateReceiptSalesTax(header, calculateTotalPrice(lineItemList) * TAX_RATE_TEN_PERCENT);
        generateReceiptTotalAmount(header, calculateTotalPrice(lineItemList) + calculateTotalPrice(lineItemList) * TAX_RATE_TEN_PERCENT);

        return header.toString();
    }

    private static double calculateTotalPrice(List<LineItem> lineItemList) {
        return lineItemList.stream()
                .map(LineItem::totalAmount)
                .reduce(Double::sum)
                .orElse(ZORO_PRICE);
    }


}