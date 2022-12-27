package br.com.swa.spring3web.services;

import br.com.swa.spring3web.entities.Product;
import br.com.swa.spring3web.entities.User;
import br.com.swa.spring3web.repositories.ProductRepository;
import br.com.swa.spring3web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();

    }

    public Product findById(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }

}
