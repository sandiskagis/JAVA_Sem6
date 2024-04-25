package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "GradeTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade {

	@Column(name="IdG")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	int idG;
	
	@Min(0)
	@Max(10)
	@Column(name="Grvalue")
	private int grValue;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="idC")
	private Course course;
	
	
	@ManyToOne
	@JoinColumn(name="idS")
	private Student student;
	
	public Grade(Student student, Course course, int grvalue)
	{
		setStudent(student);
		setCourse(course);
		setGrValue(grvalue);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
