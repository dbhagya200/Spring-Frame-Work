package lk.ijse._14_spring_boot2.service;

import lk.ijse._14_spring_boot2.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void save (CustomerDTO customerDTO);
    public List<CustomerDTO> getCustomer();
    public void updateCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(String id);
}
