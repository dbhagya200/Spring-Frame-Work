package lk.ijse._14_spring_boot2.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse._14_spring_boot2.dto.CustomerDTO;
import lk.ijse._14_spring_boot2.dto.OrderDetailsDTO;
import lk.ijse._14_spring_boot2.dto.OrdersDTO;
import lk.ijse._14_spring_boot2.entity.Customer;
import lk.ijse._14_spring_boot2.entity.Item;
import lk.ijse._14_spring_boot2.entity.OrderDetails;
import lk.ijse._14_spring_boot2.entity.Orders;
import lk.ijse._14_spring_boot2.repository.CustomerRepo;
import lk.ijse._14_spring_boot2.repository.ItemRepo;
import lk.ijse._14_spring_boot2.repository.OrderDetailsRepo;
import lk.ijse._14_spring_boot2.repository.OrdersRepo;
import lk.ijse._14_spring_boot2.service.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderDetailsRepo orderDetailRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    @Transactional
    public void save(OrdersDTO ordersDTO) {
        Orders order = modelMapper.map(ordersDTO, Orders.class);
        ordersRepo.save(order);

        for (OrderDetailsDTO detailDTO : ordersDTO.getOrderDetails()) {
            OrderDetails orderDetail = modelMapper.map(detailDTO, OrderDetails.class);
            orderDetail.setOrders(order);
            orderDetailRepo.save(orderDetail);

            Optional<Item> optionalItem = itemRepo.findById(detailDTO.getItemCode());
            if (optionalItem.isPresent()) {
                Item item = optionalItem.get();
                item.setQuantity(item.getQuantity() - detailDTO.getQuantity());
                itemRepo.save(item);
            } else {
                throw new RuntimeException("Item not found: " + detailDTO.getItemCode());
            }
        }

//        orderDetailRepo.save(modelMapper.map(orderDetailsDTO,OrderDetails.class));


//        Customer customer = new Customer();
//        customer.setId(customerDTO.getId());
//        Orders orders = new Orders();
//        orders.setOrderDate(new Date());
//        orders.setCustomer(customer);
//
//        double total = 0;
//        for (OrderDetails detail : orderDetails) {
//            Item item = itemRepo.findById(detail.getItem().getCode())
//                    .orElseThrow(() -> new RuntimeException("Item not found"));
//            detail.setItem(item);
//            detail.setUnitPrice(item.getPrice());
//            detail.setTotal(detail.getUnitPrice() * detail.getQuantity());
//            total += detail.getTotal();
//            detail.setOrders(orders);
//        }
//        orders.setTotal(total);
//        orders.setOrderDetails(orderDetails);


    }
}
