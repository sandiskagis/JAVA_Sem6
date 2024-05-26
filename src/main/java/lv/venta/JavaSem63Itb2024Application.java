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
				profRepo.save(p1);
				profRepo.save(p2);
				
				Course c1 = new Course("JAVA", 4, p1);
				Course c2 = new Course("Algoritmu teorija", 2, p2);
				courseRepo.save(c1);
				courseRepo.save(c2);
				
				Grade gr1 = new Grade(st1, c1, 2);
				Grade gr2 = new Grade(st1, c1, 9);
				Grade gr3 = new Grade(st1, c2, 2);
				Grade gr4 = new Grade(st1, c2, 3);
				Grade gr5 = new Grade(st1, c2, 8);
				Grade gr6 = new Grade(st2, c1, 2);
				Grade gr7 = new Grade(st2, c1, 6);
				Grade gr8 = new Grade(st2, c2, 1);
				Grade gr9 = new Grade(st2, c2, 3);
				Grade gr10 = new Grade(st2, c2, 9);
				grRepo.save(gr1);
				grRepo.save(gr2);
				grRepo.save(gr3);
				grRepo.save(gr4);
				grRepo.save(gr5);
				grRepo.save(gr6);
				grRepo.save(gr7);
				grRepo.save(gr8);
				grRepo.save(gr9);
				grRepo.save(gr10);
			}
		};
	}
	
}