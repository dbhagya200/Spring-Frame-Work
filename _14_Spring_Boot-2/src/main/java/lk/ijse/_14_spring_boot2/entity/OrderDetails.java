package lk.ijse._14_spring_boot2.entity;

import jakarta.persistence.*;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailsId;
    private int quantity;
    private double total;

    @ManyToOne
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "itemCode", nullable = false)
    private Item item;

    public OrderDetails() {
    }

    public OrderDetails(int orderDetailsId, int quantity, double total, Orders orders, Item item) {
        this.orderDetailsId = orderDetailsId;
        this.quantity = quantity;
        this.total = total;
        this.orders = orders;
        this.item = item;
    }

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderDetailsId=" + orderDetailsId +
                ", quantity=" + quantity +
                ", total=" + total +
                ", orders=" + orders +
                ", item=" + item +
                '}';
    }
}
