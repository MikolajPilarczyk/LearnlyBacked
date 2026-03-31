package com.example.learnlybacked;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // Pozwala Reactowi na kontakt (CORS)
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String receiveUser(@RequestBody UserLoginDTO  user) {
        System.out.println("Odebrano: " + user.getUserEmail());
            userRepository.save(user);
        return "Dane odebrane i zapisane pomyślnie!";
    }


}