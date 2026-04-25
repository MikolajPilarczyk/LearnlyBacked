package com.example.learnlybacked;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "UsersPlaylistsSets")
public class UserPlaylistsSetTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String category;
    private List<String> tags;


    @ManyToOne()
    @JoinColumn(name = "userId")
    private UserLoginDTO user;


    @OneToMany(cascade = CascadeType.ALL , mappedBy = "userPlaylistsSet")
    private List<PlaylistTable> playlists = new ArrayList<>();

    public void addPlaylist(PlaylistTable playlistTable) {
        playlists.add(playlistTable);
        playlistTable.setUserPlaylistsSet(this);
    }





}


