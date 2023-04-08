package model;

public class Product {
    private int id;
    private String name;
    private int price;
    private int QOH;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQOH() {
        return QOH;
    }

    public void setQOH(int QOH) {
        this.QOH = QOH;
    }

    public Product(int id, String name, int price, int QOH) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.QOH = QOH;
    }

    public Product() {
    }
}
