package lk.ijse._13_spring_boot.service;

import lk.ijse._13_spring_boot.dto.CustomerDTO;
import lk.ijse._13_spring_boot.entity.Customer;
import lk.ijse._13_spring_boot.repository.CustomerRepo;
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
    public void save (CustomerDTO customerDTO) {
//        Customer customer = new Customer(
//                customerDTO.getId(),
//                customerDTO.getName(),
//                customerDTO.getAddress());
//        customerRepo.save(customer);
//
//        System.out.println("Service Layer; "+customerDTO.getAddress());
//        return customerDTO;

        if (customerRepo.existsById(customerDTO.getId())) {
            throw new RuntimeException("Customer already exist");
        }
        customerRepo.save
                (modelMapper.map(customerDTO, Customer.class));

    }


    @Override
    public List<CustomerDTO> getCustomer() {
//        List<Customer> all = customerRepo.findAll();
//        List<CustomerDTO> customerDTOS = all.stream().map((customer) -> new CustomerDTO(
//                customer.getId(),
//                customer.getName(),
//                customer.getAddress()
//        )).toList();
//        System.out.println("List: "+customerDTOS);
//        return customerDTOS;

       return modelMapper.map(customerRepo.findAll(),
                new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
//        Customer customer = new Customer(
//                customerDTO.getId(),
//                customerDTO.getName(),
//                customerDTO.getAddress());
//        customerRepo.save(customer);
//        return customerDTO;

//        customerRepo.save(modelMapper.map(customerDTO,Customer.class));
        if (!customerRepo.existsById(customerDTO.getId())) {

            throw new RuntimeException("Customer not found");
        }
        customerRepo.save(modelMapper.map(customerDTO,Customer.class));
    }

    @Override
    public void deleteCustomer(int id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        }
        throw new RuntimeException("Customer does not exist");
    }
}
