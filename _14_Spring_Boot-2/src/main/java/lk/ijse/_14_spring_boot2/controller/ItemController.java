package lk.ijse._14_spring_boot2.controller;

import lk.ijse._14_spring_boot2.dto.ItemDTO;
import lk.ijse._14_spring_boot2.service.impl.ItemServiceImpl;
import lk.ijse._14_spring_boot2.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemServiceImpl itemService;

    @PostMapping(path = "save",produces = "application/json")
    public ResponseUtil saveItem(@RequestBody ItemDTO itemDTO){
        itemService.saveItem(itemDTO);
        return new ResponseUtil(
                201,"Item saved",null
        );
    }
    @GetMapping(path = "get",produces = "application/json")
    public ResponseUtil getAllItems() {
        return new ResponseUtil(
                200,"Items",itemService.getAllItems());
    }
    @PutMapping(path = "update")
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        itemService.updateItem(itemDTO);
        return new ResponseUtil(
                200,"Item updated",null
        );
    }


    @DeleteMapping(path = "delete",params = "code")
    public ResponseUtil deleteCustomer(@RequestParam (value = "code") String code){
        itemService.deleteItem(code);
        return new ResponseUtil(
                200,"Item deleted",null
        ) ;

    }

}
