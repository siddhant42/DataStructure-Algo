package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStreams {
	static List<Employee> employeeList=
		      Arrays.asList(new Employee("Tom Jones", 45), 
		                    new Employee("Harry Major", 25),
		                    new Employee("Ethan Hardy", 65),
		                    new Employee("Nancy Smith", 15),
		                    new Employee("Deborah Sprightly", 29));
	public static void main(String[] args) {
		List<Employee> filteredList = employeeList.stream().limit(2).collect(Collectors.toList());
		filteredList.forEach(System.out::println);
		Stream.iterate(0,n->n+2).peek(num->System.out.println("peeked at "+num)).limit(5).forEach(System.out::println);
	}
}
