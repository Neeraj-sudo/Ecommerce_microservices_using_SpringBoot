package com.store.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.entities.Store;


@Repository
public interface StoreRepo extends JpaRepository<Store,Integer> {
	
	public List<Store> getByPincode(String pincode);

}
