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

    @Override
    public boolean matches(Product product, String search) {
        if (super.matches(product, search)) {
            return true;
        }
        if (product instanceof Smartphone) {
            if (((Smartphone) product).getVendor().contains(search)) {
                return true;
            }
        }
        return false;
    }

}
