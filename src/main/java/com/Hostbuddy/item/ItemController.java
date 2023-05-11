package com.Hostbuddy.item;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping(value="/items")
	public List<Item> getAllSubjects()
	{
		return itemService.getAllitems();
	}
	
	@PostMapping(value="/additem")
	public void additem(@RequestBody Item item)
	{
		itemService.additem(item);
	}

	@GetMapping("/name")
    public ResponseEntity<Optional<Item>> getSubjectsById(@PathVariable String name) {
        Optional<Item> item = itemService.getItemByname(name);
        return ResponseEntity.ok().body(item);
    }
}
