package info.michalak.mvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.michalak.mvc.data.entities.Project;
import info.michalak.mvc.data.services.ProjectService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/project")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired //This will be auto invoked From application-context.xml
	private ProjectService projectService;

// Passes  LIST of Project Object  from Above Beaned Service 
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String goFind(Model model) {
		model.addAttribute("goFind", this.projectService.findAll());
		
		System.out.println(" goFind Worked");
		
		return "projects_table";
	}
// Passes ID in the link from above mapped model translates to long 
	@RequestMapping(value = "/find/{projectId}")
	public String goFindProject(Model model,@PathVariable("projectId") Long projectIds) {
		model.addAttribute("goFindIds", this.projectService.find(projectIds));
		
		System.out.println(" goFindProject Worked");
		
		return "project_view";
	
	}
	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
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
//POST	+ @MODELATRUBUTE!!!  DATABINDING
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	
	public String doAddProject(@ModelAttribute Project project) {
		
		System.out.println("doAddProject Worked");
		return "project_add";
	}
// Mapped based on FORM PARAMETERS
	@RequestMapping(value = "/add", method = RequestMethod.POST, params={"type=multi","special"})
	public String doAddProject2() {
		
		System.out.println("doAddProject2 Worked");
		return "project_add";
	}
	
// Show Model	
	@RequestMapping(value = "/ProjectCheck", method = RequestMethod.GET)
	public String showModel (Model model) {
		Project pro =new Project ();
		pro.setName("Project Name");
		pro.setSponsor("Project Sponsor");
		pro.setDescription("Project descryption");
		
		model.addAttribute("projectObjectInModel", pro);
		
		System.out.println(" showModel Worked");
		return "project_check";
	
	}
	
	
	
	
	
	
}
