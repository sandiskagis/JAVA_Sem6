package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.ICourseFilterService;

@Controller
@RequestMapping("/course/filter")
public class CourseFilterController {
	
	@Autowired
	private ICourseFilterService courseService;

	@GetMapping("/cp/{param}") //localhost:8080/course/filter/cp/4
	public String getCourseFilterByCp(@PathVariable("param") int cp, Model model) {
		
		try {
			model.addAttribute("mydata", courseService.selectCoursesByCP(cp));
			return "course-all-show-page";
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";
		}
		
	}
	
}
