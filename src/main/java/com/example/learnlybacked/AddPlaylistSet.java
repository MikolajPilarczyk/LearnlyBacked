package com.example.learnlybacked;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class AddPlaylistSet
{
    @Data
    class Song
    {
        String title;
        String url;
    }

    @Data
    class Playlist
    {
        String title;
        List<Song> songs;
    }

    @Data
    class PlaylistSetFormData
    {
        String title;
        String category;
        String[] tags;
        List<Playlist> playlists;
    }


    @PostMapping("/upload")
    public String RecivePlaylistSet(@RequestBody PlaylistSetFormData data)
    {

        return "";
    }

}
