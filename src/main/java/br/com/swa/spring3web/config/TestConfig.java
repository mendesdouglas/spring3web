package br.com.swa.spring3web.config;

import br.com.swa.spring3web.entities.Category;
import br.com.swa.spring3web.entities.Order;
import br.com.swa.spring3web.entities.Product;
import br.com.swa.spring3web.entities.User;
import br.com.swa.spring3web.entities.enums.OrderStatus;
import br.com.swa.spring3web.repositories.CategoryRepository;
import br.com.swa.spring3web.repositories.OrderRepository;
import br.com.swa.spring3web.repositories.ProductRepository;
import br.com.swa.spring3web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        User u1 = new User(null, "Douglas Mendes", "douglas@gmail.com", "988883838338", "123456");
        User u2 = new User(null, "Fegnando Martines", "fernando@gmail.com", "983838383","123456");

        Order o1 = new Order(null, Instant.parse("2022-06-20T19:50:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2022-06-20T22:33:07Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2022-06-21T00:40:06Z"),OrderStatus.WAITING_PAYMENT,u1);



        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
