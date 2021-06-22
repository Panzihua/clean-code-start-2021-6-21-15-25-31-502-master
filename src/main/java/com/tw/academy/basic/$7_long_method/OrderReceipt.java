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
    public static final double ZERO_PRICE = 0d;
    public static final String STRING_TAB = "\t";
    public static final String STRING_NEW_LINE = "\n";
    private final Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    @Deprecated
    public String printCustomerName() {
        return order.getCustomerName();
    }

    public String generateReceipt() {
        return generateReceiptHeader().append(generateReceiptBody(order.getLineItems())).toString();
    }

    private StringBuilder generateReceiptSalesTax(double totSalesTx) {
        return new StringBuilder().append("Sales Tax").append(STRING_TAB).append(totSalesTx);
    }

    private StringBuilder generateReceiptTotalAmount(double totalAmount) {
        return new StringBuilder().append("Total Amount").append(STRING_TAB).append(totalAmount);
    }

    private StringBuilder generateReceiptHeader() {
        return new StringBuilder("======Printing Orders======")
                .append(STRING_NEW_LINE)
                .append(generateReceiptCustomerName())
                .append(generateReceiptCustomerAddress());
    }

    private String generateReceiptCustomerName() {
        return order.getCustomerName();
    }

    private String generateReceiptCustomerAddress() {
        return order.getCustomerAddress();
    }

    private StringBuilder generateReceiptBody(List<LineItem> lineItemList) {
        return lineItemList.stream()
                .map(lineItem -> new StringBuilder().append(lineItem.getDescription())
                        .append(STRING_TAB)
                        .append(lineItem.getPrice())
                        .append(STRING_TAB)
                        .append(lineItem.getQuantity())
                        .append(STRING_TAB)
                        .append(lineItem.totalAmount())
                        .append(STRING_NEW_LINE)
                )
                .reduce(StringBuilder::append)
                .map(lineItemListString ->
                        lineItemListString.append(generateReceiptSalesTax(calculateTotalTax(lineItemList)))
                        .append(generateReceiptTotalAmount(calculateTotalAmount(lineItemList)))
                )
                .orElse(new StringBuilder());
    }

    private static double calculateTotalAmountWithoutTax(List<LineItem> lineItemList) {
        return lineItemList.stream()
                .map(LineItem::totalAmount)
                .reduce(Double::sum)
                .orElse(ZERO_PRICE);
    }

    private static double calculateTotalAmount(List<LineItem> lineItemList) {
        return calculateTotalAmountWithoutTax(lineItemList) + calculateTotalTax(lineItemList);
    }

    private static double calculateTotalTax(List<LineItem> lineItemList) {
        return calculateTotalAmountWithoutTax(lineItemList) * TAX_RATE_TEN_PERCENT;
    }
}