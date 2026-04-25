package com.example.learnlybacked;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class AddPlaylistSet
{
    public static class FormDataSongs
    {
        public String title;
        public String url;
    }
    public static class FormDataUserPlaylists
    {
        public String title;
        public List<FormDataSongs> songs;
    }
    public static class FormDataPlaylistSet
    {
        public String username;
        public String title;
        public String category;
        public List<String> tags;
        public List<FormDataUserPlaylists> playlists;
    }




    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserPlaylistsSetTableRepository userPlaylistsSetTableRepository;



    @Transactional
    @PostMapping("/upload")
    public String RecivePlaylistSet(@RequestBody FormDataPlaylistSet data)
    {
        UserPlaylistsSetTable dataToSave = new UserPlaylistsSetTable();
        Long userID = userRepository.getUserIdByUsername(data.username);
        if (userID == null) {
            System.out.println(data.username);
            return "Błąd: Nie znaleziono użytkownika o nazwie: " + data.username;
        }

        dataToSave.setTitle(data.title);
        dataToSave.setCategory(data.category);
        dataToSave.setTags(data.tags);
        dataToSave.setUser(userRepository.getReferenceById(userID));

        for (int i = 0; i < data.playlists.size(); i++) {
            //Current playlists
            PlaylistTable playlistToSave = new PlaylistTable();
            playlistToSave.setTitle(data.playlists.get(i).title);

            for (int j = 0; j < data.playlists.get(i).songs.size(); j++) {
                //Current Song
                SongsTable song = new SongsTable();
                song.setTitle(data.playlists.get(i).songs.get(j).title);
                song.setUrl(data.playlists.get(i).songs.get(j).url);

                playlistToSave.addSong(song);
            }

            dataToSave.addPlaylist(playlistToSave);
        }

        userPlaylistsSetTableRepository.save(dataToSave);


        return "Zapisano Very Good";
    }

}
