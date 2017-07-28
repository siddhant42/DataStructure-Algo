package stream;

import java.util.Arrays;
import java.util.List;

public class MatchingWithStreams {
	static List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45),
			new Employee("Harry Major", 25),
			new Employee("Ethan Hardy", 65),
			new Employee("Nancy Smith", 22),
			new Employee("Deborah Sprightly", 29));

	public static void main(String[] args) {
		boolean allEmpAbove21 = employeeList.stream()
				.allMatch(emp -> emp.getAge() > 21);
		System.out.println("All employees are above 21:" + allEmpAbove21);
		boolean empAbove40 = employeeList.stream()
				.anyMatch(emp->emp.getAge()>40);
		System.out.println("Any employee is above 40:" + empAbove40);
		boolean noEmpBelow30 = employeeList.stream()
				.noneMatch(emp->emp.getAge()<30);
		System.out.println("No employee is below 30:" + noEmpBelow30);
		long c = Arrays.asList("siddhant","sid",null,"one","").stream().filter(emp->emp!=null && !emp.isEmpty()).count();
		System.out.println(c);
	}
}
