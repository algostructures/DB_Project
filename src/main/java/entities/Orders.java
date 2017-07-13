package entities;

import java.util.Date;

/**
 * Created by prajapas on 7/13/2017.
 */
public class Orders {
    String orderedBy;
    String orderId;
    String vehiclemodel;
    String sparePart;
    int numbers;
    double price;
    double tax;
    Date date;

    public Orders(String orderedBy, String orderId, String vehiclemodel, String sparePart, int numbers, double price, double tax, Date date) {
        this.orderedBy = orderedBy;
        this.orderId = orderId;
        this.vehiclemodel = vehiclemodel;
        this.sparePart = sparePart;
        this.numbers = numbers;
        this.price = price;
        this.tax = tax;
        this.date = date;
    }

    public String getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(String orderedBy) {
        this.orderedBy = orderedBy;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getVehiclemodel() {
        return vehiclemodel;
    }

    public void setVehiclemodel(String vehiclemodel) {
        this.vehiclemodel = vehiclemodel;
    }

    public String getSparePart() {
        return sparePart;
    }

    public void setSparePart(String sparePart) {
        this.sparePart = sparePart;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
