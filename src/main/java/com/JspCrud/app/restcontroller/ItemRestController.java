package com.JspCrud.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JspCrud.app.model.Item;
import com.JspCrud.app.service.ItemService;


@RestController
public class ItemRestController {
	
	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("/viewstudentsc")  
    public   List<Item>  viewstudentsc(){  
        List<Item> list=itemService.allItem();
//        return new ModelAndView("viewstudents","list",list);  
        return list;
    } 
}
