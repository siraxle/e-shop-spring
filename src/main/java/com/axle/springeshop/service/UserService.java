package com.axle.springeshop.service;

import com.axle.springeshop.domain.User;
import com.axle.springeshop.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends UserDetailsService { //security
    boolean save(UserDTO userDTO);

    List<UserDTO> getAll();

    User findByName(String name);

    void updateProfile(UserDTO dto);
}
