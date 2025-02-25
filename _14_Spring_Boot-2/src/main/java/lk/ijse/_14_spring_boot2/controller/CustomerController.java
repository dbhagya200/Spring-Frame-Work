package lk.ijse._14_spring_boot2.controller;

import lk.ijse._14_spring_boot2.dto.CustomerDTO;
import lk.ijse._14_spring_boot2.repository.CustomerRepo;
import lk.ijse._14_spring_boot2.service.impl.CustomerServiceImpl;
import lk.ijse._14_spring_boot2.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping(path = "save",produces = "application/json")
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.save(customerDTO);
        return new ResponseUtil(
                201,"Customer is saved",null
        );
    }

    @GetMapping(path = "get",produces = "application/json")
    public ResponseUtil getAllCustomer(){
        return new ResponseUtil(
                200,"SUCCESS",customerService.getCustomer()
        );
    }
    @GetMapping("/last-id")
    public int getLastCustomerId() {
        return customerRepo.findLastCustomerId(); // Return a number (e.g., 5)
    }

    @PutMapping(path = "update")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        return new ResponseUtil(
                200,"Customer updated",null
        );

    }

    @DeleteMapping(path = "delete",params = "id")
    public ResponseUtil deleteCustomer(@RequestParam (value = "id") String id){
        customerService.deleteCustomer(id);
        return new ResponseUtil(
                200,"Customer deleted",null
        ) ;

    }

}
