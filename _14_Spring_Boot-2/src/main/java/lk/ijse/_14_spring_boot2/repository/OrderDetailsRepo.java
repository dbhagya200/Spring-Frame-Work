package lk.ijse._14_spring_boot2.repository;

import lk.ijse._14_spring_boot2.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, String> {
}
