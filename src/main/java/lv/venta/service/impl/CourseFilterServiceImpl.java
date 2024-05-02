package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.service.ICourseFilterService;

@Service
public class CourseFilterServiceImpl implements ICourseFilterService{

	@Autowired
	private ICourseRepo courseRepo;
	
	@Autowired
	private IProfessorRepo profRepo;
	
	@Override
	public ArrayList<Course> selectCoursesByCP(int cp) throws Exception {
		if(cp < 0 || cp >20) throw new Exception("The limit of CP is wrong");
		
		ArrayList<Course> result = courseRepo.findByCp(cp);
		
		if(result.isEmpty())
			throw new Exception("There is no course with " + cp + "creditpoints");
		
		return result;
	}
	
	
	

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(int id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(!profRepo.existsById(id))
			throw new Exception("Professor with ID: " + id + " doesent exist");
		
		ArrayList<Course> result = courseRepo.findByProfessorIdP(id);
		
		if(result.isEmpty())
			throw new Exception("There is no linkage between this professor and course");
		
		return null;
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
