package com.example.learnlybacked;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "UsersPlaylistsSet")
public class UserPlaylistsSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userID;
    private String playlistID;
    private String title;
    private String category;
    private String[] tags;



}
