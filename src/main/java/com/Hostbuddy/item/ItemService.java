package com.Hostbuddy.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ItemService {
	@Autowired
	private ItemRepo itemRepo;
	
		public List<Item> getAllitems()
	{
		List<Item> item = new ArrayList<>();
		itemRepo.findAll().forEach((Consumer) item);
		return item;
	}
		
		public void additem(Item item) {
			itemRepo.save(item);
		}
		
		public Optional<Item> getItemByname(String name) {
		    Optional<Item> item = itemRepo.findByname(name);
		    return item;
		}

}
