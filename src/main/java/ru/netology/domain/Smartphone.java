package ru.netology.domain;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String title, int cost, String manufacturer) {
        super(id, title, cost);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (manufacturer.contains(search)) {
            return true;
        }
        return false;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
