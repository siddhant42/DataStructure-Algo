package model;

import java.time.LocalDate;

public class Person {

	public Person(String name, LocalDate birthday, String gender) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
	}

	public String name;
	public LocalDate birthday;
	public String gender;
	
	public static int compare(Person a,Person b){
		return a.birthday.compareTo(b.birthday);
	}
	
	public String toString(){
		return name+" "+birthday;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public String getGender() {
		return gender;
	}
	
	
}

