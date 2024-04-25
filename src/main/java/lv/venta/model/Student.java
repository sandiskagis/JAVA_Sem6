package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//TODO Professor
//TODO Class


@Table(name = "StudentTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
	
	@Column(name = "IdS")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idS;
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 2, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	private String name;
	

	@Column(name = "Surname")
	@NotNull
	@Size(min = 2, max = 20)
	@Pattern(regexp = "[A-Z]{1}[a-z]+")
	private String surname;
	
	
	public Student(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
	
	
}
