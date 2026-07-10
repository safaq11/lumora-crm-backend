package com.customercrm.service;

import java.util.List;

import com.customercrm.dto.ChangePasswordDTO;
import com.customercrm.dto.UserDTO;

public interface UserService {

    // ================= PROFILE =================

    UserDTO getProfile(String username);

    UserDTO updateProfile(String username, UserDTO dto);

    // ================= USER MANAGEMENT =================

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO createUser(UserDTO dto);

    UserDTO updateUser(Long id, UserDTO dto);

    void deleteUser(Long id);
    
    void toggleStatus(Long id);

    void changePassword(
            ChangePasswordDTO dto);
}