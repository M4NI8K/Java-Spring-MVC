package info.michalak.mvc.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/project")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goHome() {
		
		System.out.println(" home Worked");
		return "home";
	}
//GET	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String goAddProject() {
		
		System.out.println("goAddProject Worked");
		return "project_add";
	}
//POST	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAddProject() {
		
		System.out.println("doAddProject Worked");
		return "project_add";
	}
// Mapped based on FORM PARAMETERS
	@RequestMapping(value = "/add", method = RequestMethod.POST, params={"type=multi","special"})
	public String doAddProject2() {
		
		System.out.println("doAddProject2 Worked");
		return "project_add";
	}
	
}
