package lk.ijse._14_spring_boot2.service.impl;

import lk.ijse._14_spring_boot2.dto.ItemDTO;
import lk.ijse._14_spring_boot2.entity.Item;
import lk.ijse._14_spring_boot2.repository.ItemRepo;
import lk.ijse._14_spring_boot2.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void saveItem(ItemDTO itemDTO) {

        if (itemRepo.existsById(itemDTO.getCode())){
            throw new RuntimeException("Item already exist");
        }
        itemRepo.save(modelMapper.map(
                itemDTO, Item.class
        ));
    }
    @Override
    public List<ItemDTO> getAllItems() {
        return modelMapper.map(itemRepo.findAll(),
                new TypeToken<List<ItemDTO>>(){}.getType());
    }



    @Override
    public void updateItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getCode())) {
            itemRepo.save(modelMapper.map(itemDTO,Item.class));
        }
        throw new RuntimeException("Item not found");
    }

    @Override
    public void deleteItem(String code) {
        if (itemRepo.existsById(code)) {
            itemRepo.deleteById(code);
        }
        throw new RuntimeException("Item does not exist");
    }
}
