package ru.netology.domain;


public class Smartphone extends Product {

    private String vendor;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getVendor().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

}
