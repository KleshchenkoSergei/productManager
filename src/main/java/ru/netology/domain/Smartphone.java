package ru.netology.domain;


public class Smartphone extends Product {

    String PhoneName;
    String vendor;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String phoneName, String vendor) {
        super(id, name, price);
        PhoneName = phoneName;
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }

    public void setPhoneName(String phoneName) {
        PhoneName = phoneName;
    }

    public static boolean matches(Product product, String search) {
        Smartphone smartphone = (Smartphone) product;
        if (smartphone.getVendor().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

}
