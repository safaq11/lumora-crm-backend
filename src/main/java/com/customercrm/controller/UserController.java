package com.customercrm.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customercrm.dto.ChangePasswordDTO;
import com.customercrm.dto.UserDTO;
import com.customercrm.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;

    }

    
   //profile

    @GetMapping("/profile/{username}")
    public ResponseEntity<UserDTO> getProfile(
            @PathVariable String username) {

        return ResponseEntity.ok(
                userService.getProfile(username));

    }

    @PutMapping("/profile/{username}")
    public ResponseEntity<UserDTO> updateProfile(
            @PathVariable String username,
            @RequestBody UserDTO dto) {

        return ResponseEntity.ok(
                userService.updateProfile(username, dto));

    }

    
    // USER MANAGEMENT
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        return ResponseEntity.ok(
                userService.getAllUsers());

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                userService.getUserById(id));

    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(
            @RequestBody UserDTO dto) {

        return new ResponseEntity<>(
                userService.createUser(dto),
                HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable Long id,
            @RequestBody UserDTO dto) {

        return ResponseEntity.ok(
                userService.updateUser(id, dto));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id){
    	
        System.out.println("CONTROLLER DELETE CALLED");
        
        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> toggleStatus(
            @PathVariable Long id){

        userService.toggleStatus(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/change-password")
    public ResponseEntity<String>
    changePassword(

            @RequestBody
            ChangePasswordDTO dto){

        userService.changePassword(dto);

        return ResponseEntity.ok(
                "Password Changed Successfully"
        );

    }
}