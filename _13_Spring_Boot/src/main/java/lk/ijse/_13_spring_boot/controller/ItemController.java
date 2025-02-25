package lk.ijse._13_spring_boot.controller;

import lk.ijse._13_spring_boot.dto.ItemDTO;
import lk.ijse._13_spring_boot.service.ItemServiceImpl;
import lk.ijse._13_spring_boot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    @PostMapping( path = "save")
    public ResponseUtil saveItem(@RequestBody ItemDTO itemDTO) {
        itemService.addItem(itemDTO);

            return  new ResponseUtil(
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
    public ResponseUtil deleteCustomer(@RequestParam (value = "code") int code){
        itemService.deleteItem(code);
        return new ResponseUtil(
                200,"Item deleted",null
        ) ;

    }


}
