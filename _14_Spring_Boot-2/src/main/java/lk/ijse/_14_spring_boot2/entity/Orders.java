package lk.ijse._14_spring_boot2.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    private String orderId;
    private Date orderDate;
    private Double total;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetails;

    public Orders() {
    }

    public Orders( String orderId, Date orderDate, Double total, Customer customer, List<OrderDetails> orderDetails) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.total = total;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }



    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Orders{" +
                ", orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", total=" + total +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
