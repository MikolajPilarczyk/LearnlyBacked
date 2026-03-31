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
    private  boolean agreeToTerms;
    // Gettery i settery (lub adnotacja @Data z Lombok)
}
