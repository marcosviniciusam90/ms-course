package com.devsuperior.hruser.resources;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRepository;
import com.devsuperior.hruser.resources.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/search")
    public User findByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
