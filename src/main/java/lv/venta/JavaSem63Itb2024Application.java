package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class JavaSem63Itb2024Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSem63Itb2024Application.class, args);
	}

	@Bean
	public CommandLineRunner testDatabaseLayer(IProfessorRepo profRepo, IStudentRepo stuRepo, 
			ICourseRepo courseRepo, IGradeRepo grRepo)
	{
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Student st1 = new Student("Janis", "Berzins");
				Student st2 = new Student("Baiba", "Jauka");
				stuRepo.save(st1);
				stuRepo.save(st2);
				
				Professor p1 = new Professor("Karina", "Skirmante", Degree.mg);
				Professor p2 = new Professor("Vairis", "Caune", Degree.phd);
				Professor p3 = new Professor("Mārcis", "Naktins", Degree.mg);
				Professor p4 = new Professor("Arturs", "Orbidans", Degree.mg);
				profRepo.save(p1);
				profRepo.save(p2);
				profRepo.save(p3);
				profRepo.save(p4);
				
				Course c1 = new Course("JAVA", 4, p1);
				Course c2 = new Course("Algoritmu teorija", 2, p2);
				Course c3 = new Course("Objektorienteta programmesana", 1, p1);
				Course c4 = new Course("Operetajsistemas", 2, p3, p4);
				courseRepo.save(c1);
				courseRepo.save(c2);
				courseRepo.save(c3);
				courseRepo.save(c4);
				
				
				p1.addCourse(c1);
				p1.addCourse(c3);
				profRepo.save(p1);
				
				p2.addCourse(c2);
				profRepo.save(p2);
				
				p3.addCourse(c4);
				profRepo.save(p3);
				
				p4.addCourse(c4);
				profRepo.save(p4);
				
				
				
				
				Grade gr1 = new Grade(st1, c1, 6);
				Grade gr2 = new Grade(st1, c2, 9);
				Grade gr3 = new Grade(st2, c1, 10);
				grRepo.save(gr1);
				grRepo.save(gr2);
				grRepo.save(gr3);
				
			}
		};
	}
	
}