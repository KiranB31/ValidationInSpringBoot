package com.example.validation.controller;

import com.example.validation.entity.LoginRequest;
import com.example.validation.entity.User;
import com.example.validation.exception.ResourseNotFoundException;
import com.example.validation.repository.UserRepository;
import com.example.validation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {


    private final UserRepository userRepository;

    private final UserService userService;

    //get all users
    @GetMapping("/getAllUsersList")
    public List<User> getAllUsers()
    {

        return this.userRepository.findAll();
    }

    // get user by id
    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable(value ="id") Long id){
        return this.userRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("User not found with id :"+id));
    }

    //create user
    @PostMapping("/createUsers")
    public User createUser( @Valid @RequestBody User user){
//        User user1 = User.builder().userName(user.getUserName()).firstName(user.getFirstName()).build();
//       User u2 = UserBuilder.firstName(user.getFirstName()).lastName(user.getLastName()).build();
//       return this.userRepository.save(user1);
        return this.userRepository.save(user);


    }

    //update user
    @PutMapping("/updateUser/{id}")
    public User updateUser( @Valid @RequestBody User user, @PathVariable("id") Long id)
    {
        User existing = this.userRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("User not found with id :"+id));
        existing.setUserName(user.getUserName());
        existing.setFirstName(user.getFirstName());
        existing.setLastName(user.getLastName());
        existing.setEmail(user.getEmail());

      return this.userRepository.save(existing);
    }

    //delete user by id
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable ("id") Long id)
    {
        User existing = this.userRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("User not found with id : " +id));
        this.userRepository.delete(existing);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/validatelogin")
    public String validateLogin(@RequestBody LoginRequest loginRequest) {

        String message = userService.validateLogin(loginRequest);

        return message;
    }

    @GetMapping(value = "getUsers/{name}")
    public User findByUserName(@PathVariable("name") String userName) {
        User users =  this.userService.getUserByUsername(userName);
        return users;
    }

    @GetMapping(value = "getUserss/{id}")
    public User findById(@PathVariable("id") Long id,@RequestBody User user){

        User user1 = this.userService.getByUserId(user,id);
        return user1;
    }

}
