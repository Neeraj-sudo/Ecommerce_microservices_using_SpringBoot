package com.prodstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prodstore.entities.AppUser;
import com.prodstore.exceptions.AppUserNotFoundException;
import com.prodstore.repo.AppUserRepo;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserRepo appUserRepo;

	@Override
	public List<AppUser> getAll() {
		return appUserRepo.findAll();
	}

	@Override
	public AppUser addAppUser(AppUser appUser) {
		appUserRepo.save(appUser);
		return appUser;
	}

	@Override
	public AppUser updateAppUser(long appUserId, AppUser appUser) {
		AppUser userToUpdated = findById(appUserId);
		userToUpdated.setAddress(appUser.getAddress());
		userToUpdated.setEmail(appUser.getEmail());
		userToUpdated.setPhone(appUser.getPhone());
		userToUpdated.setPassword(appUser.getPassword());
		appUserRepo.save(userToUpdated);
		return userToUpdated;
	}

	@Override
	public AppUser deleteAppUser(String email) {
		AppUser userToDelete = findByEmail(email);
		appUserRepo.delete(userToDelete);
		return userToDelete;
	}

	@Override
	public AppUser findByEmail(String email) {
		return appUserRepo.findByEmail(email);
	}

	@Override
	public AppUser findById(Long appUserId) {
		return appUserRepo.findById(appUserId).orElseThrow(() -> new AppUserNotFoundException("app user not found"));
	}

}





