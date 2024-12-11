package com.itc.app.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itc.app.productEntity.userEntity;
import com.itc.app.Repository.userRepositories;

@Service
public class itcCustomUserDetailsService implements UserDetailsService{
	 @Autowired
	    private userRepositories userRepositories;

	    @Override
	    public UserDetails loadUserByUsername(String userPhone) throws UsernameNotFoundException {
//	    	System.out.println("this is to check");
	        userEntity user = userRepositories.findByUserPhone(userPhone)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + userPhone));
	        
	        System.out.println("Retrieved password from DB: " + user.getUserPassword());
	        
	        return User.builder()
	            .username(user.getUserPhone())
	            .password(user.getUserPassword())
	            .roles("USER")
	            .build();
	    }
}
