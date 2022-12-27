package br.com.swa.spring3web.repositories;

import br.com.swa.spring3web.entities.Category;
import br.com.swa.spring3web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
