package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{

	//public abstract pec noklusejuma
	ArrayList<Course> findByCp(int cp);

	//public abstract pec noklusejuma
	ArrayList<Course> findByProfessorIdP(int id);

}