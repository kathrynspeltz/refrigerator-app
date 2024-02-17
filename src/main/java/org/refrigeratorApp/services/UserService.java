package org.refrigeratorApp.services;

import org.refrigeratorApp.dtos.UserDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    @javax.transaction.Transactional
    List<String> userLogin(UserDto userDto);
}
