package entities;

import java.util.Date;

/**
 * Created by prajapas on 7/13/2017.
 */
public class Orders {
    String orderedBy;
    String orderId;
    String vehicleModel;
    String sparePartId;
    String sparePartName;
    String operation;
    int numbers;
    double price;
    double tax;
    Date date;

    public Orders(String orderedBy, String orderId, String vehicleModel, String sparePartId, String sparePartName, String operation, int numbers, double price, double tax, Date date) {
        this.orderedBy = orderedBy;
        this.orderId = orderId;
        this.vehicleModel = vehicleModel;
        this.sparePartId = sparePartId;
        this.sparePartName = sparePartName;
        this.operation = operation;
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

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getSparePartId() {
        return sparePartId;
    }

    public void setSparePartId(String sparePartId) {
        this.sparePartId = sparePartId;
    }

    public String getSparePartName() {
        return sparePartName;
    }

    public void setSparePartName(String sparePartName) {
        this.sparePartName = sparePartName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
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
