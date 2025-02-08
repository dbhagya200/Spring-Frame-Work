package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin(origins = "http://localhost:63342")
public class CustomerController {

    List<CustomerDTO> customers = new ArrayList<>();

    @PostMapping("save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        customers.add(customerDTO);
        System.out.println("Save successfull ");
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
        System.out.println("Updated successfull ");
        return customerDTO;
    }

    @GetMapping("getall")
    public List<CustomerDTO> getAllCustomer(){
        System.out.println("GetAll successfull ");
        return customers;
    }

    @DeleteMapping(path = "delete", params = "id")
    public boolean deleteCustomer(@RequestParam(value = "id" ) String id){
       for(CustomerDTO customer : customers){
           if(customer.getId().equals(id)){
               return customers.remove(customer);
           }
       }
       System.out.println("Delete successfull "+id);
       return false;

    }
}
