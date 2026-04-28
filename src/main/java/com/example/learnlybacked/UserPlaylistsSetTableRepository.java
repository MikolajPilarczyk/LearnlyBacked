package com.example.learnlybacked;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPlaylistsSetTableRepository extends JpaRepository<UserPlaylistsSetTable, Long> {


    @Query("SELECT p FROM UserPlaylistsSetTable p WHERE p.user = :user")
    List<UserPlaylistsSetTable> findById(@Param("user") UserLoginDTO user);


    List<UserPlaylistsSetTable> findByUser(UserLoginDTO user);
}
