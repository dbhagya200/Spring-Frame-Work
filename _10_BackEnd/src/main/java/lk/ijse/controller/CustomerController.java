package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    List<CustomerDTO> customers = new ArrayList<>();

    @PostMapping("save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        customers.add(customerDTO);
        return customerDTO;
    }

    @PutMapping("update")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO){
        for (int i=0; i<customers.size(); i++){
            CustomerDTO existCustomer = customers.get(i);
            if (existCustomer.getId().equals(customerDTO.getId())){
                customers.set(i, customerDTO);
                break;

            }
        }
        return customerDTO;
    }

    @GetMapping("getall")
    public List<CustomerDTO> getAllCustomer(){
        return customers;
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteCustomer(@PathVariable(value = "id" ) String id){
        for (int i = 0; i<customers.size(); i++){
            CustomerDTO existingCustomer = customers.get(i);
            if (existingCustomer.getId().equals(id)){
                customers.remove(i);
                break;
            }
        }
        System.out.println("Delete successfull "+id);
    }
}
