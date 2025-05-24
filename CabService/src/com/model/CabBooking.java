package com.model;

import java.util.Date;

public class CabBooking {

    private Customer customer;
    private Route route;
    private Date bookingDate;
    private Date travelDate;
    private BookingPrice priceDetail;

    public CabBooking(Customer customer, Route route, Date bookingDate, Date travelDate, BookingPrice priceDetail) {
        this.customer = customer;
        this.route = route;
        this.bookingDate = bookingDate;
        this.travelDate = travelDate;
        this.priceDetail = priceDetail;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public BookingPrice getPriceDetail() {
        return priceDetail;
    }

    public void setPriceDetail(BookingPrice priceDetail) {
        this.priceDetail = priceDetail;
    }
}
