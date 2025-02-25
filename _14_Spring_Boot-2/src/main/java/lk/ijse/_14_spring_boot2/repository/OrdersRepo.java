package lk.ijse._14_spring_boot2.repository;

import lk.ijse._14_spring_boot2.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<OrderDetails,String> {
}
