package lk.ijse._14_spring_boot2.dto;

import java.util.Date;
import java.util.List;

public class OrdersDTO {
    private int orderId;
    private Date orderDate;
    private int customerId;
    private List<OrderDetailsDTO> orderDetails;
}
