package com.example.learnlybacked;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class UserProfileController {


    public record UserProfileData(String username,String bio, int likes, int materials) {
    }
    public record UsernameToSend(String usernameToFind){}




    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public UserProfileData ReceiveUser(@RequestBody UserLoginDTO user) {

        UserProfileData returnData = userRepository.takeUserProfileDataByUsername(user.getUserNameAndSurname());


        System.out.println( "wyslano dane" + returnData);
        return returnData;
    }

    @PostMapping("/find/user")
    public Integer FindUser(@RequestBody UsernameToSend user) {

        if(userRepository.findUserByUsername(user.usernameToFind)==1)
            return 1;
        else return 0;
    }



    @PostMapping("/user/playlists")
    public UserPlaylistsSetTable Playlists(@RequestBody UsernameToSend user) {
        UserPlaylistsSetTable returnData = new UserPlaylistsSetTable();





        return returnData;
    }
}
