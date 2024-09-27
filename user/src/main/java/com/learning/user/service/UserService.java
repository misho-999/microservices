package com.learning.user.service;

import com.learning.user.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    List<User> findAllUsersAsPage(Pageable pageable);

    User findUserById(Integer id);

    User createNewUser(User user);

    User updateExistingUser(Integer id, User user);

    void deleteExistingUserById(Integer id);

    User updateUserEmail(Integer id, String email);
}
