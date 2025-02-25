package lk.ijse._14_spring_boot2.dto;

import java.util.Date;
import java.util.List;

public class OrdersDTO {
    private String orderId;
    private Date orderDate;
    private Double total;
    private String customerId;
    private List<OrderDetailsDTO> orderDetails;

    public OrdersDTO() {
    }

    public OrdersDTO( String orderId, Date orderDate, Double total, List<OrderDetailsDTO> orderDetails) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.total = total;
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

    public List<OrderDetailsDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                ", orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", total=" + total +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
