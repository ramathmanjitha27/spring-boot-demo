package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("get-users")
    public List<UserDTO> getUsers(){
         return userService.getAllUsers();
    }

    @GetMapping("get-user-by-id/{id}")
    public UserDTO getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PostMapping("save")
    public UserDTO save(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("update")
    public UserDTO update(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("delete/{userId}")
    public String delete(@PathVariable Integer userId){
        return userService.deleteUser(userId);
    }
}
