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

    private StringBuilder generateReceiptSalesTax(double totSalesTx) {
        return new StringBuilder().append("Sales Tax").append('\t').append(totSalesTx);
    }

    private StringBuilder generateReceiptTotalAmount(double totalAmount) {
        return new StringBuilder().append("Total Amount").append('\t').append(totalAmount);
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
        return lineItemList.stream()
                .map(lineItem -> new StringBuilder().append(lineItem.getDescription())
                        .append('\t')
                        .append(lineItem.getPrice())
                        .append('\t')
                        .append(lineItem.getQuantity())
                        .append('\t')
                        .append(lineItem.totalAmount())
                        .append('\n')
                )
                .reduce(header, StringBuilder::append)
                .append(generateReceiptSalesTax(calculateTotalTax(lineItemList)))
                .append(generateReceiptTotalAmount(calculateTotalPrice(lineItemList) + calculateTotalTax(lineItemList)))
                .toString();
    }

    private static double calculateTotalPrice(List<LineItem> lineItemList) {
        return lineItemList.stream()
                .map(LineItem::totalAmount)
                .reduce(Double::sum)
                .orElse(ZORO_PRICE);
    }

    private static double calculateTotalTax(List<LineItem> lineItemList) {
        return calculateTotalPrice(lineItemList) * TAX_RATE_TEN_PERCENT;
    }


}