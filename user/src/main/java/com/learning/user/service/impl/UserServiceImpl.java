package com.learning.user.service.impl;

import com.learning.user.model.User;
import com.learning.user.repository.UserRepository;
import com.learning.user.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllUsersAsPage(Pageable pageable) {
        return userRepository.findAll(
                        PageRequest.of(
                                pageable.getPageNumber(),  // page index for the second page - indexing starts at 0
                                pageable.getPageSize(), // page size (the last page might have fewer items)
                                pageable.getSortOr(Sort.by(Sort.Direction.DESC, "id")))) //If Sort is missing use default one
                .getContent();
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateExistingUser(Integer id, User user) {

        User currUser = findUserById(id);

        if (currUser == null) {
            return null;
        }

        currUser.setCars(user.getCars());
        currUser.setEmail(user.getEmail());
        currUser.setUsername(user.getUsername());

        userRepository.save(currUser);

        return currUser;
    }

    @Override
    public User updateUserEmail(Integer id, String email) {
        User user = findUserById(id);

        user.setEmail(email);
        userRepository.save(user);

        return user;
    }

    @Override
    public void deleteExistingUserById(Integer id) {
        userRepository.delete(findUserById(id));
    }
}
