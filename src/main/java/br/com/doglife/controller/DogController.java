package br.com.doglife.controller;

import br.com.doglife.entity.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private MongoOperations mongoOperations;

    @PostMapping
    public void save(@RequestBody Dog dog) {
        mongoOperations.save(dog);
    }

    @GetMapping("/")
    public List<Dog> findAll() {
        return mongoOperations.findAll(Dog.class);
    }

    @GetMapping("/:id")
    public Dog findById(@RequestParam String id) {
        return mongoOperations.findById(id, Dog.class);
    }

    @PutMapping
    public void update(@RequestBody Dog dog) {
    }

    @DeleteMapping
    public void delete(@RequestParam String id) {
        Dog dog = mongoOperations.findById(id, Dog.class);
        mongoOperations.remove(dog);
    }
}
