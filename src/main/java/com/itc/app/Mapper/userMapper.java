package com.itc.app.Mapper;

import com.itc.app.Dto.userDto;
import com.itc.app.productEntity.userEntity;

public class userMapper {
	
	public static userDto mapToUserDto(userEntity UserEntity) {
		return new userDto(
				UserEntity.getUserId(),
				UserEntity.getUserName(),
				UserEntity.getUserPassword(),
				UserEntity.getUserPhone(),
				UserEntity.getUserLocation(),
				UserEntity.getUserRole()
				);			
		}
		
	public static userEntity mapTouserEntity(userDto UserDto) {
		return new userEntity(
				UserDto.getUserId(),
				UserDto.getUserName(),
				UserDto.getUserPassword(),
				UserDto.getUserPhone(),
				UserDto.getUserLocation(),
				UserDto.getUserRole()
				);
	}
}
