package com.example.learnlybacked;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserLoginDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userNameAndSurname;
    private String userEmail;
    private String password;
    private String accountType;
    private String bio;
    private String imagePath;
    private int likes = 0;
    private int materials = 0;
    private  boolean agreeToTerms;
    // Gettery i settery (lub adnotacja @Data z Lombok)
}
