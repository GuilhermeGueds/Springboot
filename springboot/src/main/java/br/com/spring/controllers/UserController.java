package br.com.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.controllers.model.User;
import br.com.spring.repository.UserRepository;;

@RestController
@RequestMapping("/users")
public class UserController {

    private ArrayList<User> listUsers = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public User user(@RequestBody User user) {
        return this.userRepository.save(user);

    }

    @GetMapping("/list")
    public List<User> allUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id) {
        Optional<User> userFind = this.userRepository.findById(id);
        if (userFind.isPresent()) {
            return userFind.get();
        }
        return null;
    }

    @GetMapping("/list/{id}")
    public List<User> listMoreThan(@PathVariable("id") Long id) {
        return this.userRepository.findAllMoreThan(id);
    }

    @GetMapping("/findById/{id}")
    public List<User> listMoreThanJpa(@PathVariable("id") Long id) {
        return this.userRepository.findByIdGreaterThan(id);
    }

    @GetMapping("/findByName/{name}")
    public List<User> listMoreThanJpa(@PathVariable("name") String name) {
        return this.userRepository.findByNameIgnoreCase(name);

    }

}
