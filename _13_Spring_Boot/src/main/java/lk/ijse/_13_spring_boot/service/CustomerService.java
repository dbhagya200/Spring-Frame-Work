package lk.ijse._13_spring_boot.service;

import lk.ijse._13_spring_boot.dto.CustomerDTO;
import lk.ijse._13_spring_boot.entity.Customer;
import lk.ijse._13_spring_boot.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public CustomerDTO save (CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress());
        customerRepo.save(customer);

        System.out.println("Service Layer; "+customerDTO.getAddress());
        return customerDTO;
    }

    public List<CustomerDTO> getCustomer() {
        List<Customer> all = customerRepo.findAll();
        List<CustomerDTO> customerDTOS = all.stream().map((customer) -> new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress()
        )).toList();
        System.out.println("List: "+customerDTOS);
        return customerDTOS;
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress());
        customerRepo.save(customer);
        return customerDTO;
    }

    public boolean deleteCustomer(CustomerDTO customerDTO) {
        customerRepo.deleteById(customerDTO.getId());
        return true;
    }
}
