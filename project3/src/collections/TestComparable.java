package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable{
	int rollno;
	String name;
	int age;
	
	public Student(int rollno, String name, int age) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Object o) {
		Student st=(Student)o;
		if(st.age==age) return 0;
		return age>st.age?1:-1;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", age=" + age
				+ "]";
	}
	
}
public class TestComparable {
	public static void main(String[] args) {
		
	
Student s1=new Student(11, "sid", 25);
Student s2=new Student(18, "vikas", 30);
Student s3=new Student(11, "Anil", 28);
List<Student> al=new ArrayList<Student>();
al.add(s1);
al.add(s2);
al.add(s3);
Collections.sort(al);
for(Student st:al){
	System.out.println(st);
}
}
}