package lk.ijse._14_spring_boot2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Item {

    @Id
    private String code;
    private String name;
    public int quantity;
    public double price;
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetails;

    public Item() {
    }

    public Item(String code, String name, int quantity, double price, List<OrderDetails> orderDetails) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.orderDetails = orderDetails;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
