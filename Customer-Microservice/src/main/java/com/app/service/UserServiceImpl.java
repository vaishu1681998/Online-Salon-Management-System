package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.app.dto.BookingDto;
import com.app.dto.UserDto;
import com.app.entity.Role;
import com.app.entity.Users;
import com.app.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		Users user = modelMapper.map(userDto, Users.class);
		// Ensure mobileNo is provided
		if (user.getMobileNo() == null) {
			throw new IllegalArgumentException("Mobile number must not be null");
		}
		Users savedUser = userRepository.save(user);
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(Long id) {
		Optional<Users> user = userRepository.findById(id);
		return user.map(u -> modelMapper.map(u, UserDto.class))
				.orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(Long id, UserDto userDto) {
	    Users existingUser = userRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));

	    // Manually update fields
	    existingUser.setName(userDto.getName());
	    existingUser.setEmail(userDto.getEmail());
	    existingUser.setMobileNo(userDto.getMobileNo());
	    existingUser.setSex(userDto.getSex());

	    // Convert String to Role enum safely
	    try {
	        String roleStr = userDto.getRole();
	        if (roleStr != null) {
	            existingUser.setRole(Role.valueOf(roleStr.toUpperCase())); // Convert String to Role enum
	        } else {
	            throw new IllegalArgumentException("Role cannot be null");
	        }
	    } catch (IllegalArgumentException e) {
	        throw new RuntimeException("Invalid role value: " + userDto.getRole(), e);
	    }

	    Users updatedUser = userRepository.save(existingUser);
	    return modelMapper.map(updatedUser, UserDto.class);
	}




	@Override
	public void deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new EntityNotFoundException("User not found with id " + id);
		}
		userRepository.deleteById(id);
	}

}
