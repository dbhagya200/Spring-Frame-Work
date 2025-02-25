package lk.ijse._14_spring_boot2.repository;

import lk.ijse._14_spring_boot2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query("SELECT MAX(c.id) FROM Customer c")
    Integer findLastCustomerId();
}
