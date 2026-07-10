package com.customercrm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customercrm.dto.ChangePasswordDTO;
import com.customercrm.dto.UserDTO;
import com.customercrm.entity.User;
import com.customercrm.exception.ResourceNotFoundException;
import com.customercrm.repository.UserRepository;
import com.customercrm.service.UserService;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;

    }

    @Override
    public UserDTO getProfile(String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Not Found"));

        return convertToDTO(user);

    }

    @Override
    public UserDTO updateProfile(String username, UserDTO dto) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Not Found"));

        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setMobile(dto.getMobile());

        user.setProfileImage(dto.getProfileImage());

        User updatedUser = userRepository.save(user);

        return convertToDTO(updatedUser);

    }
    @Override
    public List<UserDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();

    }
    
    @Override
    public UserDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Not Found"));

        return convertToDTO(user);

    }
    @Override
    public UserDTO createUser(UserDTO dto) {

        User user = new User();

        user.setUsername(dto.getUsername());

        user.setPassword(dto.getPassword());

        user.setFullName(dto.getFullName());

        user.setEmail(dto.getEmail());

        user.setMobile(dto.getMobile());

        user.setRole(dto.getRole());

        user.setProfileImage(dto.getProfileImage());

        user.setActive(true);

        User savedUser = userRepository.save(user);

        return convertToDTO(savedUser);

    }
    @Override
    public UserDTO updateUser(Long id, UserDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Not Found"));

        user.setFullName(dto.getFullName());

        user.setEmail(dto.getEmail());

        user.setMobile(dto.getMobile());

        user.setRole(dto.getRole());

        user.setProfileImage(dto.getProfileImage());

        user.setActive(dto.isActive());

        User updatedUser = userRepository.save(user);

        return convertToDTO(updatedUser);

    }
    
    @Override
    @Transactional
    public void deleteUser(Long id){

        System.out.println("DELETE METHOD CALLED");

        User user =
                userRepository
                .findById(id)
                .orElseThrow(
                    () -> new RuntimeException(
                            "User not found"));

        System.out.println("FOUND USER : "
                + user.getUsername());

        userRepository.delete(user);

        System.out.println("DELETE EXECUTED");
    }
    //Inactive/active status toggle 
    @Override
    @Transactional
    public void toggleStatus(Long id){

        User user =
                userRepository
                        .findById(id)
                        .orElseThrow();

        user.setActive(
                !user.isActive());

        userRepository.save(user);

    }
    @Override
    public void changePassword(
            ChangePasswordDTO dto){

        User user =
                userRepository
                        .findByUsername(
                                dto.getUsername())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User Not Found"
                                ));

        System.out.println(
                "Entered Password : "
                + dto.getOldPassword());

        System.out.println(
                "DB Password : "
                + user.getPassword());

        if(!user.getPassword()
                .trim()
                .equals(
                    dto.getOldPassword()
                    .trim()
                ))
        {
            throw new RuntimeException(
                    "Old Password Incorrect"
            );
        }

        user.setPassword(
                dto.getNewPassword()
        );

        userRepository.save(user);

    }
    
    private UserDTO convertToDTO(User user) {

        UserDTO dto = new UserDTO();

        dto.setId(user.getId());

        dto.setUsername(user.getUsername());

        dto.setFullName(user.getFullName());

        dto.setEmail(user.getEmail());

        dto.setMobile(user.getMobile());

        dto.setRole(user.getRole());

        dto.setProfileImage(user.getProfileImage());

        dto.setCreatedDate(user.getCreatedDate());

        dto.setLastLogin(user.getLastLogin());
        
        dto.setActive(user.isActive());
        
   
        return dto;

    }

}