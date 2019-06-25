package jannkasper.spring.controllers;

import jannkasper.spring.api.model.ListDTO;
import jannkasper.spring.api.model.UserDTO;
import jannkasper.spring.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    public static final String BASE_URL = "/api/user";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListDTO<UserDTO> getListOfUsers() {
        return new ListDTO<UserDTO>(userService.getAllUsers());
    }

    @GetMapping({BASE_URL + "/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById (@PathVariable String id) {
        return userService.getUserById(id);
    }
    @GetMapping({BASE_URL + "/{customerName}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserByCustomerName (@PathVariable String customerName) {
        return userService.getUserByCustomerName(customerName);
    }
    @GetMapping({BASE_URL + "/{login}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserByLogin (@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser (@RequestBody UserDTO userDTO){
        return userService.createNewUser(userDTO);
    }

    @PutMapping({BASE_URL + "/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser (@PathVariable String id, @RequestBody UserDTO userDTO){
        return userService.saveUserByDTO(id, userDTO);
    }


    @DeleteMapping({BASE_URL + "/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String id){
        userService.deleteUserById(id);
    }

}
