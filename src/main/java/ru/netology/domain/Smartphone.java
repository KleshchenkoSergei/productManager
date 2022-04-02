package ru.netology.domain;

public class Smartphone extends Product {

    private String PhoneName;
    private String vendor;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String phoneName, String vendor) {
        super(id, name, price);
        PhoneName = phoneName;
        this.vendor = vendor;
    }

    public void setPhoneName(String phoneName) {
        PhoneName = phoneName;
    }

    public String getPhoneName() {
        return PhoneName;
    }
}
