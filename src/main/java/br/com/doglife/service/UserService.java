package br.com.doglife.service;

import br.com.doglife.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

@Service
public class UserService {

    @Autowired
    private MongoOperations mongoOperations;

    public User findByUsernameAndPassword(String username, String password) {
        Query query = new Query(Criteria.where("username").is(username).and("password").is(password));
        return mongoOperations.findOne(query, User.class);
    }

}
