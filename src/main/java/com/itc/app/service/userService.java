package com.itc.app.service;

import java.util.List;

import com.itc.app.Dto.userDto;

public interface userService {
	userDto createNewUser(userDto UserDto);
	userDto getUserById(Long userId);
	List<userDto> getAllUsers();
	void deleteUserById(Long userId);
	void registerUser(userDto UserDto);
}
