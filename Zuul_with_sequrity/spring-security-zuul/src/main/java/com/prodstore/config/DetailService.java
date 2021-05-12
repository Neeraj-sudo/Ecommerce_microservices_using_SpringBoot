package com.prodstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prodstore.entities.AppUser;
import com.prodstore.service.AppUserService;
@Service
public class DetailService implements UserDetailsService{
	
	@Autowired
	private AppUserService appUserService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser appUser=appUserService.findByEmail(email);
		if(appUser==null)
			throw new UsernameNotFoundException("user with email "+ email+ " is not found");
		//i need to convert the appuser to the spring sec user
		//?
		return new User(appUser.getEmail(), appUser.getPassword(),
				AuthorityUtils.createAuthorityList(new String[] {appUser.getProfile()}));
	}

}








