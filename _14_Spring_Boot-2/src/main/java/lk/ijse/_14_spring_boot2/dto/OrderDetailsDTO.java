package lk.ijse._14_spring_boot2.dto;

import lk.ijse._14_spring_boot2.entity.Item;

public class OrderDetailsDTO {
    private int orderDetailsId;
    private Integer quantity;

    private Double unitPrice;

    private Double total;
    private String itemId;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(int orderDetailsId, Integer quantity, Double unitPrice, Double total, String itemId) {
        this.orderDetailsId = orderDetailsId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
        this.itemId = itemId;
    }

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" +
                "orderDetailsId=" + orderDetailsId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", total=" + total +
                ", itemId='" + itemId + '\'' +
                '}';
    }
}
