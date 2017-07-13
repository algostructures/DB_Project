package entities;

/**
 * Created by prajapas on 7/13/2017.
 */
public class SpareParts {
    private String vehicle_model;
    private String sparepart_ID;
    private double price;
    private double tax;
    private int numbers;

    public SpareParts(String vehicle_model, String sparepart_ID, double price, double tax, int numbers) {
        this.vehicle_model = vehicle_model;
        this.sparepart_ID = sparepart_ID;
        this.price = price;
        this.tax = tax;
        this.numbers = numbers;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public String getSparepart_ID() {
        return sparepart_ID;
    }

    public void setSparepart_ID(String sparepart_ID) {
        this.sparepart_ID = sparepart_ID;
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

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
}
