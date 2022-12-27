package br.com.swa.spring3web.repositories;

import br.com.swa.spring3web.entities.OrderItem;
import br.com.swa.spring3web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
