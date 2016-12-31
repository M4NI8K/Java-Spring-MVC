package info.michalak.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.michalak.mvc.data.entities.Resource;

@Controller
@RequestMapping(value = "/resource")
public class ResourceController {

	@RequestMapping(value = "/add")
	public String goAdd(Model model) {
// LIST of list Attributes that were added to the model and displayed as 
		//Drop Down (one from)
		List<String> optionsList = new LinkedList<>(
				Arrays.asList(new String[] { "Material", "Other", "Staff", "Technical Equipment" }));
		model.addAttribute("typeOptions", optionsList);
		// Radio buttons (one of)
		List<String> radiosList = new LinkedList<>(
				Arrays.asList(new String[] { "Hours", "Pice", "Tons"}));
		model.addAttribute("radioOptions", radiosList);
		// check boxes (any of) stored as list   String[] indicators
		List<String> checksList = new LinkedList<>(
				Arrays.asList(new String[] { "Lead Time", "Special Rate", "Requires Approval"}));
		model.addAttribute("checkOptions", checksList);
		
		
		model.addAttribute("resource", new Resource());

		System.out.println("goAdd WORKED");
		return "resource_add";
	}
// Data Binded model @ModelAttribute Resource resource
	@RequestMapping(value = "/save")
	public String doSaveAdd(Model model, @ModelAttribute Resource resource) {
		Resource res = new Resource();
		model.addAttribute("resource", res);

		System.out.println("doSaveAdd WORKED ! ! !");
		// resource displayed after taken from the form
		System.out.println(resource);
		return "home";
	}

}
