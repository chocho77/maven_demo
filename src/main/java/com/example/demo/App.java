package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

// Това създава таблицата автоматично
@Entity
@Table(name = "users")
class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String email;
}

// Това управлява заявките към базата
interface UserRepository extends JpaRepository<User, Long> {}

// Това прави данните достъпни в браузъра
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200") // Разрешава достъп от Angular приложението
class UserController {
    private final UserRepository repository;
    UserController(UserRepository repository) { this.repository = repository; }

    @GetMapping
    public List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/add")
    public User addUser(@RequestParam String name, @RequestParam String email) {
        User newUser = new User();
        newUser.name = name;
        newUser.email = email;
        return repository.save(newUser);        
    }
}
