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

        generateReceiptBody(receiptContent, order.getLineItems());

        return receiptContent.toString();
    }

    private void generateReceiptSalesTax(StringBuilder receiptContent, double totSalesTx) {
        receiptContent.append("Sales Tax").append('\t').append(totSalesTx);
    }

    private void generateReceiptTotalAmount(StringBuilder receiptContent, double totalAmount) {
        receiptContent.append("Total Amount").append('\t').append(totalAmount);
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

    private void generateReceiptBody(StringBuilder receiptContent, List<LineItem> lineItemList) {
        lineItemList
                .forEach(lineItem -> {
                        receiptContent.append(lineItem.getDescription());
                        receiptContent.append('\t');
                        receiptContent.append(lineItem.getPrice());
                        receiptContent.append('\t');
                        receiptContent.append(lineItem.getQuantity());
                        receiptContent.append('\t');
                        receiptContent.append(lineItem.totalAmount());
                        receiptContent.append('\n');
                });

        generateReceiptSalesTax(receiptContent, calculateTotalPrice(lineItemList) * TAX_RATE_TEN_PERCENT);
        generateReceiptTotalAmount(receiptContent, calculateTotalPrice(lineItemList) + calculateTotalPrice(lineItemList) * TAX_RATE_TEN_PERCENT);
    }

    private static double calculateTotalPrice(List<LineItem> lineItemList) {
        return lineItemList.stream()
                .map(LineItem::totalAmount)
                .reduce(Double::sum)
                .orElse(ZORO_PRICE);
    }


}