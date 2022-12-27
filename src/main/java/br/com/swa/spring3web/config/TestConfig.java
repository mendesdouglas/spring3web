package br.com.swa.spring3web.config;

import br.com.swa.spring3web.entities.Order;
import br.com.swa.spring3web.entities.User;
import br.com.swa.spring3web.repositories.OrderRepository;
import br.com.swa.spring3web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Douglas Mendes", "douglas@gmail.com", "988883838338", "123456");
        User u2 = new User(null, "Fegnando Martines", "fernando@gmail.com", "983838383","123456");

        Order o1 = new Order(null, Instant.parse("2022-06-20T19:50:07Z"),u1);
        Order o2 = new Order(null, Instant.parse("2022-06-20T22:33:07Z"), u2);
        Order o3 = new Order(null, Instant.parse("2022-06-21T00:40:06Z"),u1);
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
