package com.itc.app.productServiceImplemets;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itc.app.Dto.itcAuthRequest;
import com.itc.app.Dto.userDto;
import com.itc.app.Mapper.userMapper;
import com.itc.app.Repository.userRepositories;
import com.itc.app.productEntity.userEntity;
import com.itc.app.service.userService;

@Service
public class userServiceImplemets implements userService {
	@Autowired
	public userRepositories UserRepositories;
	private final BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public userServiceImplemets(userRepositories userRepositories,
			@Qualifier("passwordEncoder") PasswordEncoder passwordEncoder) {
		super();
		UserRepositories = userRepositories;
		this.passwordEncoder = (BCryptPasswordEncoder) passwordEncoder;
	}

	@Override
	public userDto createNewUser(userDto UserDto) {
		// TODO Auto-generated method stub
		userEntity UserEntity = userMapper.mapTouserEntity(UserDto);
		UserEntity.setUserPassword(passwordEncoder.encode(UserDto.getUserPassword()));
		userEntity saveNewUser = UserRepositories.save(UserEntity);
		return userMapper.mapToUserDto(saveNewUser);
	}

	@Override
	public userDto getUserById(Long userId) {
		// TODO Auto-generated method stub
		userEntity UserEntity = UserRepositories.findById(userId).orElse(null);
		return userMapper.mapToUserDto(UserEntity);
	}

	@Override
	public List<userDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<userEntity> UserEntity = UserRepositories.findAll();
		return UserEntity.stream().map(userMapper::mapToUserDto).collect(Collectors.toList());
	}

	@Override
	public void deleteUserById(Long userId) {
		// TODO Auto-generated method stub
		UserRepositories.findById(userId).orElse(null);
		UserRepositories.deleteById(userId);
	}

	@Override
	public void registerUser(userDto UserDto) {
		userEntity users = new userEntity();
		users.setUserId(UserDto.getUserId());
		users.setUserName(UserDto.getUserName());
		users.setUserPassword(passwordEncoder.encode(UserDto.getUserPassword()));
		users.setUserPhone(UserDto.getUserPhone());
		users.setUserLocation(UserDto.getUserLocation());
		UserRepositories.save(users);
	}

	public itcAuthRequest getUserById(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
