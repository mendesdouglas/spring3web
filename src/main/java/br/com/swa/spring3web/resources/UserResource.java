package br.com.swa.spring3web.resources;

import br.com.swa.spring3web.entities.User;
import br.com.swa.spring3web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserService services;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list =services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User>findById(@PathVariable Long id){
        User obj = services.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = services.insert(obj);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = services.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}


