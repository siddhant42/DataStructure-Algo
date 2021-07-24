package collections2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {
	int age;
	String name;
	
	public Person() {
		super();
	}

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
public void convert(Person[] p){
	List people=Arrays.asList(p);
	Collections.sort(people, new AgeComparator());
	System.out.println(people);
}
public static void main(String[] args) {
	Person[] p={new Person(10,"sid"),new Person(18,"vikal"),new Person(15,"Anil")};
	Person obj=new Person();
	obj.convert(p);
}
}
class AgeComparator implements Comparator<Person>{
	
	@Override
	public int compare(Person a,Person b) {
		// TODO Auto-generated method stub
		return (a.age>b.age)?1:(a.age==b.age)?0:-1;
	}

	/*@Override
	public int compare(Person a,Person b)
	return (a.age>b.age)?1:(a.age==b.age)?0:-1;*/
}