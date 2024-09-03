package com.app.service;

import java.util.List;

//import com.app.dto.BookingDto;
import com.app.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);

	UserDto getUserById(Long id);

	List<UserDto> getAllUsers();

	UserDto updateUser(Long id, UserDto userDto);

	void deleteUser(Long id);
	
}
