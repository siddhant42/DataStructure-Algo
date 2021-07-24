package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringSlicingStreams {
	static List<Employee> employeeList=Arrays.asList(
			   new Employee("Tom Jones", 45), 
			   new Employee("Harry Major", 25),
			   new Employee("Ethan Hardy", 65),
			   new Employee("Nancy Smith", 15),
			   new Employee("Deborah Sprightly", 29),
			   new Employee("Dick Hiddleton Sprightly", 44),
			   new Employee("Alexander Hick", 19),
			   new Employee("Harry Major", 25),
			   new Employee("Nancy Smith", 15));
			 public static void main(String args[]){
			   //filter method
			   List<Employee> filteredList= employeeList.stream().filter(e-> e.getAge() > 24).collect(Collectors.toList());
			   System.out.println("After applying filter method");
			   filteredList.forEach(System.out::println);
			   //distinct method
			   filteredList= filteredList.stream().distinct().collect(Collectors.toList());
			   System.out.println("After applying distinct() method");
			   filteredList.forEach(System.out::println);
			   //limit method
			   filteredList= filteredList.stream().limit(2).collect(Collectors.toList());
			   System.out.println("After applying limit(2) method");
			   filteredList.forEach(System.out::println);
			   //skip method
			   filteredList= filteredList.stream().skip(1).collect(Collectors.toList());
			   System.out.println("After applying skip(1) method");
			   filteredList.forEach(System.out::println);
			 } 
}
