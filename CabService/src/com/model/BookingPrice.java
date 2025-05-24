package com.model;

public class BookingPrice {

    private Double price;
    private Double discount;
    private String discountType;
    private Double totalAmount;

    public BookingPrice(Double price, Double discount, String discountType, Double totalAmount) {
        this.price = price;
        this.discount = discount;
        this.discountType = discountType;
        this.totalAmount = totalAmount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
