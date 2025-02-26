package lk.ijse._14_spring_boot2.repository;

import lk.ijse._14_spring_boot2.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PlaceOrderRepo extends JpaRepository<Orders, String> {
}
