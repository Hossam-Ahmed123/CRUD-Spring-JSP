package com.JspCrud.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JspCrud.app.model.Item;
import com.JspCrud.app.rep.ItemRepositry;

 
@Service
public class ItemService {

	@Autowired
	ItemRepositry repositry;

	public List<Item> allItem() {

		List<Item> itemList = new ArrayList<>();

		repositry.getItems().forEach(itemList::add);

		return itemList;
	}

	public String addProduct(Item item) {

		String result = repositry.addProduct(item.getName(), item.getCategory(), item.getDescription(), "123",
				item.getPrice(), item.getQuantity(), item.getRating());

		return result;
		
		
		
	}
	
	public Item selectItemById(int id){
		Optional<Item> proChack = repositry.findById(id);
		if(!proChack.isPresent()) {
			return null;
		}else {
			return proChack.get();
		}
	}
	
	

	public String editProduct(Item item) {

		String result = repositry.editProduct(item.getName(), item.getCategory(), item.getDescription(), "123",
				item.getPrice(), item.getQuantity(), item.getRating(),item.getId());

		return result;
		
		
		
	}
	
	public String removeProduct(int id) {

		String result = repositry.deleteProduct(id);

		return result;
		
		
		
	}

}
