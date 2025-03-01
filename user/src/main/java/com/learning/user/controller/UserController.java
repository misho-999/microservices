package com.learning.user.controller;

import com.learning.user.model.Car;
import com.learning.user.model.User;
import com.learning.user.service.CarService;
import com.learning.user.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    private final CarService carService;

    public UserController(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }

    /**
     * Added Principal as parameter for learning purpose. It comes from Spring Security. Debug to see the content!!!
     * authorities = ROLE_ADMIN, ROLE_USER, authenticated = true, username = admin, .....
     *
     * @param principal
     * @return
     */
    @GetMapping("/all")
    private ResponseEntity<List<User>> getAllUsers(Principal principal) {
        return ResponseEntity
                .ok()
                .body(userService.findAllUsers());
    }

    /**
     * Example http://localhost:8080/users/all-as-page?page=0&size=5&sort=id,desc
     * Query parameters:
     * page=0 (Starts from 0)
     * size=5
     * sort=id,desc
     * @return List of User in Pageable variant!!!
     */
    @GetMapping("/all-as-page")
    private ResponseEntity<List<User>> getAllUsersAsPage(Pageable pageable) {
        return ResponseEntity
                .ok()
                .body(userService.findAllUsersAsPage(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.findUserById(id);

        if (user != null) {
            return ResponseEntity
                    .ok()
                    .body(user);
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCarByUserId(@PathVariable("id") Integer id) {
        Car car = carService.getCarByUserId(id);

        if (car != null) {
            return ResponseEntity
                    .ok()
                    .body(car);
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createUser(@RequestBody User user) {
        User savedUser = userService.createNewUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/" + savedUser.getId())
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }

    //Update the whole User object
    @PutMapping("/{id}")
    private ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody User user) {
        User createdUser = userService.updateExistingUser(id, user);

        if (createdUser == null) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity
                .noContent()
                .build();
    }

    //Partial update. Only the email
    //http://localhost:8080/users/4?email=newemail@abv.bg
    @PatchMapping("/{id}")
    private ResponseEntity<Void> updateUserEmail(@PathVariable Integer id, @RequestParam String email) {

        User user = userService.updateUserEmail(id, email);

        if (user == null) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        user.setEmail(email);

        return ResponseEntity
                .noContent()
                .build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        userService.deleteExistingUserById(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
