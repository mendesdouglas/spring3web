package br.com.swa.spring3web.repositories;

import br.com.swa.spring3web.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
