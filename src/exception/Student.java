package exception;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	 int id;  
	 String name; 
	 Date birthDate;
	 public Student(int id, String name,Date birthDate) {  
	  this.id = id;  
	  this.name = name;  
	  this.birthDate = birthDate;
	 }
}
