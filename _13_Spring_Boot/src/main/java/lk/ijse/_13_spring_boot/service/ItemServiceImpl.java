package lk.ijse._13_spring_boot.service;

import lk.ijse._13_spring_boot.dto.ItemDTO;
import lk.ijse._13_spring_boot.entity.Item;
import lk.ijse._13_spring_boot.repository.ItemRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addItem(ItemDTO itemDTO) {
//        itemRepo.save(
//                new Item(
//                        itemDTO.getCode(),
//                        itemDTO.getName(),
//                        itemDTO.getQuantity(),
//                        itemDTO.getPrice()));
//        return itemDTO;

       if (itemRepo.existsById(itemDTO.getCode())) {
           throw new RuntimeException("Item already exist");
       }
       itemRepo.save(modelMapper.map(itemDTO,Item.class));
    }

@Override
    public void updateItem(ItemDTO itemDTO) {
       if (itemRepo.existsById(itemDTO.getCode())) {
           itemRepo.save(modelMapper.map(itemDTO,Item.class));
       }
        throw new RuntimeException("Item not found");

    }
    @Override
    public List<ItemDTO> getAllItems() {
    return modelMapper.map(itemRepo.findAll(),new TypeToken<List<ItemDTO>>(){}.getType());
    }

    @Override
    public void deleteItem(int code) {
        if (itemRepo.existsById(code)) {
            itemRepo.deleteById(code);
        }
        throw new RuntimeException("Item does not exist");
    }

}
