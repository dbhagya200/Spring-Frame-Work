package lk.ijse._14_spring_boot2.controller;

import lk.ijse._14_spring_boot2.dto.CustomerDTO;
import lk.ijse._14_spring_boot2.dto.OrderDetailsDTO;
import lk.ijse._14_spring_boot2.entity.OrderDetails;
import lk.ijse._14_spring_boot2.entity.Orders;
import lk.ijse._14_spring_boot2.service.PlaceOrderService;
import lk.ijse._14_spring_boot2.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class PlaceOrdersController {
    @Autowired
    private PlaceOrderService placeOrderService;

    @PostMapping(path = "save",produces = "application/json")

    public ResponseUtil placeOrder(@RequestBody CustomerDTO customerDTO,  OrderDetailsDTO orderDetailsDTO){
         placeOrderService.save(customerDTO,orderDetailsDTO);
        return new ResponseUtil(
                201,"Order is placed",null
        );
    }

    @GetMapping(path = "get",produces = "application/json")
    public ResponseUtil getAllOrders(){
        return new ResponseUtil();
    }
}
