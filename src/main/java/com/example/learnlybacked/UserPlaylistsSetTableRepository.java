package com.example.learnlybacked;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPlaylistsSetTableRepository extends JpaRepository<UserPlaylistsSetTable, Long> {
}
