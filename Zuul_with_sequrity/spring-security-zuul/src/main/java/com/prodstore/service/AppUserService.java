package com.prodstore.service;
import java.util.*;
import com.prodstore.entities.AppUser;

public interface AppUserService {
	public List<AppUser> getAll();
	public AppUser addAppUser(AppUser appUser);
	public AppUser updateAppUser(long appUserId, AppUser appUser);
	public AppUser deleteAppUser(String email);
	public AppUser findById(Long appUserId);
	public AppUser findByEmail(String email);
}
