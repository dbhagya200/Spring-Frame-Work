package lk.ijse._13_spring_boot.service;

import lk.ijse._13_spring_boot.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    public void addItem(ItemDTO itemDTO);
    public void deleteItem(int code);
    public void updateItem(ItemDTO itemDTO);
    public List<ItemDTO> getAllItems();
}
