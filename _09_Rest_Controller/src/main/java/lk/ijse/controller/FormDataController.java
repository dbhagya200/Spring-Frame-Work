package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "form")
public class FormDataController {

//    @PostMapping()
//    public String post(@RequestParam(value = "id") String id){
//        return id;
//    }

    @PostMapping
    public String get(@ModelAttribute CustomerDTO customerdto){
        System.out.println(customerdto.getFirstName());
        return customerdto.toString();
    }
}
