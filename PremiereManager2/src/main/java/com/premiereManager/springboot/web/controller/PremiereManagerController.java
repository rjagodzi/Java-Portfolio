package com.premiereManager.springboot.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.premiereManager.springboot.web.model.Premiere;
import com.premiereManager.springboot.web.service.PremiereManagerService;

@Controller
public class PremiereManagerController {

	@Autowired
	PremiereManagerService service;
	
	/**
	 * Creates a default format for the date class (dd.MM.yyyy).
	 * 
	 * @author Rafal Jagodzinski
	 * 
	 */

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	/**
	 * Shows the list of premieres of a user provided in the argument of the retrievePremieres method.
	 * 
	 * @author Rafal Jagodzinski
	 * 
	 */

	@RequestMapping(value = "/list-premieres", method = RequestMethod.GET)
	public String showPremieres(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("premieres", service.retrievePremieres(name));
		return "list-premieres";
	}
	
	/**
	 * Method gets logged in user name from Spring Security. Logged is user in
	 * Spring is Principal. At start method gets the principal. Then from principal
	 * there is get the user name.
	 * 
	 * @return Returns user name as string.
	 * 
	 * @author Lukasz Blaszkowski
	 */

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
	
	/**
	 * Shows the add premiere page.
	 * 
	 * @author Rafal Jagodzinski
	 * 
	 */

	@RequestMapping(value = "/add-premiere", method = RequestMethod.GET)
	public String showAddPremierePage(ModelMap model) {
		model.addAttribute("premiere", new Premiere(0, getLoggedInUserName(model),
				"Premiere name", new Date(), ""));
		return "premiere";
	}
	
	/**
	 * Deletes a list entry. Simulates an error message, when a user tries to delete the 6th entry.
	 * 
	 * @author Rafal Jagodzinski
	 * 
	 */

	@RequestMapping(value = "/delete-premiere", method = RequestMethod.GET)
	public String deletePremiere(@RequestParam int id) {

		if(id==6)
			throw new RuntimeException("Error.");
		
		service.deletePremiere(id);
		return "redirect:/list-premieres";
	}
	
	/**
	 * Shows an updated premiere page.
	 * 
	 * @author Rafal Jagodzinski
	 * 
	 */

	@RequestMapping(value = "/update-premiere", method = RequestMethod.GET)
	public String showUpdatePremierePage(@RequestParam int id, ModelMap model) {	
		Premiere premiere = service.retrievePremiere(id);
		model.put("premiere", premiere);
		return "premiere";
	}
	
	/**
	 * Updates a premiere by retrieving the user's name from the model.
	 * Redirects the user to the premiere list page.
	 * 
	 * @author Rafal Jagodzinski
	 * 
	 */

	@RequestMapping(value = "/update-premiere", method = RequestMethod.POST)
	public String updatePremiere(ModelMap model, @Valid Premiere premiere,
			BindingResult result) {
		if (result.hasErrors()) {
			return "premiere";
		}
		premiere.setUser(getLoggedInUserName(model));
		service.updatePremiere(premiere);
		return "redirect:/list-premieres";
	}
	
	/**
	 * Adds a new entry to the premiere list and redirects the user to the premiere list page.
	 * 
	 * @author Rafal Jagodzinski
	 * 
	 */

	@RequestMapping(value = "/add-premiere", method = RequestMethod.POST)
	public String addPremiere(ModelMap model, @Valid Premiere premiere, BindingResult result) {

		if (result.hasErrors()) {
			return "premiere";
		}

		service.addPremiere(getLoggedInUserName(model), premiere.getDesc(), premiere.getTargetDate(), premiere.getType());
		return "redirect:/list-premieres";
	}
}
