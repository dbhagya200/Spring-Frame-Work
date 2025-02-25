package lk.ijse._14_spring_boot2.dto;

import lk.ijse._14_spring_boot2.entity.Orders;

import java.util.List;

public class CustomerDTO {
    private String id;
    private String name;
    private String address;
    private List<Orders> orders;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String name, String address, List<Orders> orders) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}
