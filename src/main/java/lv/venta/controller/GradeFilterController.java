package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.IGradeFilterService;

@Controller
@RequestMapping("/grade/filter")
public class GradeFilterController {
	
	@Autowired
	private IGradeFilterService gradeService;
	
	@GetMapping("/student/{id}")//localhost:8080/grade/filter/student/2
	public String getGradeFilterStudentById(@PathVariable("id") int id, 
			Model model) {
		
		try
		{
			model.addAttribute("mydata", gradeService.selectGradesByStudentId(id));
			model.addAttribute("msg", "Grades filtered by Student ID");
			return "grade-all-show-page";
		}catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";//tiks parādīta error-page.html lapa
		}
	}
	
	@GetMapping("/student/failed/{id}")//localhost:8080/grade/filter/student/failed/2
	public String getFailedGradeFilterStudentById(@PathVariable("id") int id, 
			Model model) {

		try
		{
			model.addAttribute("mydata", gradeService.selectFailedGradesByStudentId(id));
			model.addAttribute("msg", "Failed grades filtered by Student ID");
			return "grade-all-show-page";
		}catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";//tiks parādīta error-page.html lapa
		}
	}
	
	
	@GetMapping("/course/average/{id}")//localhost:8080/grade/filter/course/average/2
	public String getAverageGradeFilterCourseById(@PathVariable("id") int id, 
			Model model) {

		try
		{
			model.addAttribute("mydata", gradeService.calculateAVGGradeInCourseById(id));
			model.addAttribute("msg", "Average grade filtered by Course ID");
			return "grade-all-show-page";
		}catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";//tiks parādīta error-page.html lapa
		}
	}
		
}