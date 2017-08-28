package br.com.doglife.controller;

import br.com.doglife.entity.User;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private PasswordEncryptor passwordEncryptor;

    @PostMapping
    public void save(@RequestBody User user) {
        user.setPassword(passwordEncryptor.encryptPassword(user.getPassword()));
        mongoOperations.save(user);
    }

    @GetMapping("/")
    public List<User> findAll() {
        return mongoOperations.findAll(User.class);
    }

    @GetMapping("/:id")
    public User findById(@RequestParam String id) {
        return mongoOperations.findById(id, User.class);
    }

    @PutMapping
    public void update(@RequestBody User user) {
    }

    @DeleteMapping
    public void delete(@RequestParam String id) {
        User user = mongoOperations.findById(id, User.class);
        mongoOperations.remove(user);
    }

}
