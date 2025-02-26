package lk.ijse._14_spring_boot2.dto;

import lk.ijse._14_spring_boot2.entity.Item;

public class OrderDetailsDTO {
    private String itemCode;
    private int quantity;
    private double unitPrice;

    private double total;
    private String orderId;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(String itemCode, int quantity, Double unitPrice, double total, String orderId) {
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", total=" + total +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
