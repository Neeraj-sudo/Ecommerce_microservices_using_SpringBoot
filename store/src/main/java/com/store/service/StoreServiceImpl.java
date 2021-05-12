package com.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store.entities.Store;
import com.store.exceptions.StoreNotFoundException;
import com.store.repo.StoreRepo;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreRepo storeRepo;

	@Override
	public List<Store> getAll() {
		return storeRepo.findAll();
	}

	@Override
	public Store addStore(Store store) {
		storeRepo.save(store);
		return store;
	}

	@Override
	public Store deleteStore(int storeId) {
		Store storeToDelete = getById(storeId);
		storeRepo.delete(storeToDelete);
		return storeToDelete;
	}

	@Override
	public Store updateStore(int storeId, Store store) {
		Store storeToUpdate = getById(storeId);
		storeToUpdate.setCity(store.getCity());
		storeToUpdate.setState(store.getState());
		storeToUpdate.setPincode(store.getPincode());
		storeToUpdate.setStoreName(store.getStoreName());
		return storeToUpdate;
		
		
	}

	@Override
	public Store getById(int storeId) {
		Store store = storeRepo.findById(storeId)
				.orElseThrow(()-> new StoreNotFoundException("store with id "+ storeId +" is not found"));
		return store;
		
	}
	
	@Override
	public List<Store> findByPincode(String pincode) {
		return storeRepo.getByPincode(pincode);
				//.orElseThrow(()-> new StoreNotFoundException("No store with "+ pincode +" is not found"));
		//return store;
		
	}

}
