package br.com.swa.spring3web.repositories;

import br.com.swa.spring3web.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
