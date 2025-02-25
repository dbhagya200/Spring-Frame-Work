package lk.ijse._14_spring_boot2.service;

import lk.ijse._14_spring_boot2.dto.CustomerDTO;
import lk.ijse._14_spring_boot2.dto.OrderDetailsDTO;
import lk.ijse._14_spring_boot2.entity.OrderDetails;
import lk.ijse._14_spring_boot2.entity.Orders;

import java.util.List;

public interface PlaceOrderService {


    void save(CustomerDTO customerDTO, OrderDetailsDTO orderDetailsDTO);
}
