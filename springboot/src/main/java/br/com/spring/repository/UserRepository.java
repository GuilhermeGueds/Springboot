package br.com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.spring.controllers.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.id > :id")
    public List<User> findAllMoreThan(@Param("id") Long id);

    // spring data jpa
    public List<User> findByIdGreaterThan(Long id);

    // spring data jpa
    public List<User> findByNameIgnoreCase(String name);

}
