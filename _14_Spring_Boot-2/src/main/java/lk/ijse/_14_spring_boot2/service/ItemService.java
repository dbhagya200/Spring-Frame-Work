package lk.ijse._14_spring_boot2.service;

import lk.ijse._14_spring_boot2.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    public void saveItem(ItemDTO itemDTO);
    public List<ItemDTO> getAllItems();
    public void updateItem(ItemDTO itemDTO);
    public void deleteItem(String code);

}
