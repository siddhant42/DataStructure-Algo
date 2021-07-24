package collections2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student1{
	int rollno;
	String name;
	int age;
	public Student1(int rollno, String name, int age) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", age=" + age
				+ "]";
	}
	
}
class AgeComparator1 implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Student1 s1=(Student1)o1;
		Student1 s2=(Student1)o2;
		if(s1.age==s2.age) return 0;
		return s1.age>s2.age?1:-1;
	}
	
}
class NameComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Student1 s1=(Student1)o1;
		Student1 s2=(Student1)o2;
		return s1.name.compareToIgnoreCase(s2.name);
	}
	
}
public class TestComparator {
	public static void main(String[] args) {
		
		
Student1 s1=new Student1(11, "sid", 25);
Student1 s2=new Student1(18, "vikas", 30);
Student1 s3=new Student1(11, "Anil", 28);
List<Student1> al1=new ArrayList<Student1>();
al1.add(s1);
al1.add(s2);
al1.add(s3);
System.out.println("printing student in order of age");
Collections.sort(al1,new AgeComparator1());
for(Student1 st:al1){
	System.out.println(st);
}
System.out.println("printing student in order of name");
Collections.sort(al1,new NameComparator());
for(Student1 st2:al1){
	System.out.println(st2);
}
}
}
