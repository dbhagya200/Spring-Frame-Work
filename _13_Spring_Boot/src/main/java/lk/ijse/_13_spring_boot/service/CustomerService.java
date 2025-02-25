package lk.ijse._13_spring_boot.service;

import lk.ijse._13_spring_boot.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
     void save (CustomerDTO customerDTO);
    public List<CustomerDTO> getCustomer();
    public void updateCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(int id);
}
