package lk.ijse._13_spring_boot.controller;

import lk.ijse._13_spring_boot.dto.CustomerDTO;
import lk.ijse._13_spring_boot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;
    @PostMapping(path = "save",produces = "application/json")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO res = customerService.save(customerDTO);
        return res;
    }

    @GetMapping(path = "get",produces = "application/json")
    public List<CustomerDTO> saveCustomer(){
        List<CustomerDTO> res = customerService.getCustomer();
        return res;
    }

    @PutMapping(path = "update",produces = "application/json")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO res = customerService.updateCustomer(customerDTO);
        return res;
    }

    @DeleteMapping(path = "delete",produces = "application/json")
    public boolean deleteCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.deleteCustomer(customerDTO);

    }

}
