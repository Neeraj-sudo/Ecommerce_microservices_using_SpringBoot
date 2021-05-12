package com.store.service;

import java.util.List;

import com.store.entities.Store;

public interface StoreService {
	List<Store> getAll();
	public Store deleteStore(int storeId);
	public Store updateStore(int storeId, Store store);
	public Store getById(int storeId);
	Store addStore(Store store);
	
	public List<Store> findByPincode(String pincode);
	

}
