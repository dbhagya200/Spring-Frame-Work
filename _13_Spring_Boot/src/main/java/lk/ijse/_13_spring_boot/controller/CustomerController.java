package lk.ijse._13_spring_boot.controller;

import lk.ijse._13_spring_boot.dto.CustomerDTO;
import lk.ijse._13_spring_boot.service.CustomerServiceImpl;
import lk.ijse._13_spring_boot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {


    @Autowired
    private CustomerServiceImpl customerService;
    @PostMapping(path = "save",produces = "application/json")
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO){
//        return customerService.save(customerDTO);

        customerService.save(customerDTO);
            return new ResponseUtil(
                    201,"Customer saved",null
            );


    }

    @GetMapping(path = "get",produces = "application/json")
    public ResponseUtil saveCustomer(){
//        List<CustomerDTO> res = customerService.getCustomer();
//        return res;

        return new ResponseUtil(
                200,"Sccess",customerService.getCustomer()
        );
    }

    @PutMapping(path = "update")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO){
       customerService.updateCustomer(customerDTO);
            return new ResponseUtil(
                    200,"Customer updated",null
            );

    }

    @DeleteMapping(path = "delete",params = "id")
    public ResponseUtil deleteCustomer(@RequestParam (value = "id") int id){
         customerService.deleteCustomer(id);
         return new ResponseUtil(
                 200,"Customer deleted",null
         ) ;

    }

}
