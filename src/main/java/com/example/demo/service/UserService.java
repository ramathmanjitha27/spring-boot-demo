package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public  UserDTO getUser(Integer id){
        User user = userRepository.getUserById(id);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO saveUser(UserDTO userDTO){
        User newUser = modelMapper.map(userDTO, User.class);
        userRepository.save(newUser);
        return userDTO;
    }

    public UserDTO updateUser(UserDTO userDTO){
        User newUser = modelMapper.map(userDTO, User.class);
        userRepository.save(newUser);
        return userDTO;
    }

    public String deleteUser(Integer userId){
        userRepository.deleteById(userId);
        return "User Deleted";
    }
}
