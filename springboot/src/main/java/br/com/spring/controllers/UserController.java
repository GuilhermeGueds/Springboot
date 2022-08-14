package br.com.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.controllers.model.User;;

@RestController
@RequestMapping("/users")
public class UserController {

    private ArrayList<User> listUsers = new ArrayList<>();

    @PostMapping("/")
    public ArrayList<User> user(@RequestBody User user) {
        listUsers.add(user);
        return listUsers;
    }

    @GetMapping("/list")
    public ArrayList<User> allUsers() {
        return this.listUsers;
    }

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id) {
        Optional<User> userFind = listUsers.stream().filter(user -> user.getId() == id).findFirst();
        if (userFind.isPresent()) {
            return userFind.get();
        }
        return null;
    }

}
