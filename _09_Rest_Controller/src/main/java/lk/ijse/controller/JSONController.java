package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("json")
public class JSONController {

    @PostMapping
    public String post(@RequestBody CustomerDTO customerDTO ){
        return customerDTO.getFirstName();
    }

    @GetMapping(path = "data",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CustomerDTO> get(){
        List<CustomerDTO> list = List.of(
                new CustomerDTO("John","Doe",23),
                new CustomerDTO("dil","perera",25));
        return list;
    }

}
