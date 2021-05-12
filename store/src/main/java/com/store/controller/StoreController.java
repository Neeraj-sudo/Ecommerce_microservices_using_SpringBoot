package com.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.entities.Store;
import com.store.service.StoreService;



@RestController
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("store")
	public ResponseEntity<List<Store>>  getAll(){
		List<Store> stores=storeService.getAll();
		
		return ResponseEntity.ok(stores);
	}

	
	@GetMapping("store/{storeId}")
	public ResponseEntity<Store>  getAnStore(@PathVariable(name = "storeId")int storeId){
		Store store=storeService.getById(storeId);
		return ResponseEntity.ok(store);
	}
	
	
	@GetMapping("store/pincode/{pincode}")
	public ResponseEntity<List<Store>>  getAnStoreByPincode( @PathVariable String pincode){
		List<Store> store=storeService.findByPincode(pincode);
		return ResponseEntity.ok(store);
	}
	
	
//	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
//	public List<Brand> getBrand(@PathVariable String name) {
//	    return brandService.getSome(name);
//	}
	
	
	
	
	
	
	
	//delete
		@DeleteMapping("store/{storeId}")
		public ResponseEntity<Void>  deleteAnStore(@PathVariable(name = "storeId")int storeId){
			Store store=storeService.deleteStore(storeId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		
		//step 5: activate validation by apply @Valid before customer in post method and
		//update method
		
		//add 
		@PostMapping("store")
		public ResponseEntity<Store>  addAnStore(@Valid  @RequestBody Store store){
			Store storeAdded=storeService.addStore(store);
			return ResponseEntity.status(HttpStatus.CREATED).body(store);
		}
		
		
		//update
		@PutMapping("store/{storeId}")
		public ResponseEntity<Store>  updateAnStore
		(@PathVariable(name = "storeId")int storeId, @Valid @RequestBody Store store){
			Store storeUpdated=storeService.updateStore(storeId, store);
			return ResponseEntity.status(HttpStatus.OK).body(storeUpdated);
		}
		
		
		
}
