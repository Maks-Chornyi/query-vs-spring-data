package com.makschornyi.queryvsspringdata.repo;

import com.makschornyi.queryvsspringdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAllByNameContains(String name);

    @Query("select u from User u where u.name like %?1% order by u.modified desc")
    List<User> findAllWeNeed(String name);
}
