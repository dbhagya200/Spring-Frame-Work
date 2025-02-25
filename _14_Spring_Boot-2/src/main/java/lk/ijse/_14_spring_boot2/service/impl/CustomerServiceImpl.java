package lk.ijse._14_spring_boot2.service.impl;

import lk.ijse._14_spring_boot2.dto.CustomerDTO;
import lk.ijse._14_spring_boot2.entity.Customer;
import lk.ijse._14_spring_boot2.repository.CustomerRepo;
import lk.ijse._14_spring_boot2.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void save(CustomerDTO customerDTO) {
            if (customerRepo.existsById(customerDTO.getId())){
                throw new RuntimeException("Customer already exist");
            }
            customerRepo.save(
                    modelMapper.map(customerDTO, Customer.class)
            );
    }

    @Override
    public List<CustomerDTO> getCustomer() {
        return modelMapper.map(customerRepo.findAll(),
                new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getId())) {

            throw new RuntimeException("Customer not found");
        }
        customerRepo.save(modelMapper.map(customerDTO,Customer.class));
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        }
        throw new RuntimeException("Customer does not exist");
    }
}
