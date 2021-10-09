package com.JspCrud.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.JspCrud.app.model.Item;
import com.JspCrud.app.service.ItemService;

@Controller

public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/viewsproduct", method = RequestMethod.GET)
	public ModelAndView viewProduct() {
		List<Item> list = itemService.allItem();
		return new ModelAndView("product_list", "list", list);

	}

	@RequestMapping(value = "/in", method = RequestMethod.GET)
	public ModelAndView in() {

		return new ModelAndView("index");

	}

	@RequestMapping(value = "/insertPage", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		ModelAndView model = new ModelAndView();
		Item e = new Item();
		model.addObject("itemForm", e);
		model.setViewName("newproduct");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView();
		Item e = itemService.selectItemById(id);
		model.addObject("itemForm", e);
		model.setViewName("updateproduct");
		return model;
	}

//	

	@RequestMapping(value = "/updatePro", method = RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute("itemForm") Item e) {

		itemService.editProduct(e);
		return new ModelAndView("redirect:/viewsproduct");
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertProduct(@ModelAttribute("itemForm") Item e) {

		itemService.addProduct(e);
		return new ModelAndView("redirect:/viewsproduct");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable("id") int id) {
		itemService.removeProduct(id);

		return new ModelAndView("redirect:/viewsproduct");
	}

}
