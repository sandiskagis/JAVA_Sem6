package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer>{

	ArrayList<Grade> findByStudentIdPe(int id);

	ArrayList<Grade> findByStudentIdPeAndGrvalueLessThan(int id, int i);

	@Query(nativeQuery = true, value = "SELECT AVG(GRVALUE) FROM GRADE_TABLE WHERE IDC=?1")
	float calculateAVGByCourseId(int id);

}