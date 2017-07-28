package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindInStreams {
	static List<Employee> employeeList = Arrays.asList(
			new Employee("Tom Jones", 45),
			new Employee("Harry Major", 25),
			new Employee("Ethan Hardy", 65),
			new Employee("Nancy Smith", 22),
			new Employee("Deborah Sprightly", 29),
			new Employee("Billy Kid", 22),
			new Employee("George King",44),
			new Employee("Annie Barrey", 19));
	public static void main(String[] args) {
		//Optional<Employee> anyEmpAbove50 = employeeList.stream().filter(emp->emp.getAge()>50).findAny();
		Optional<Integer> anyEmpAbove50 = employeeList.stream().map(emp->emp.getAge()).filter(i->i>50).findAny();
		if(anyEmpAbove50.isPresent())
			System.out.println("Any Employee above age 40: " +anyEmpAbove50.get());
		Optional<Employee> firstEmpBelow30 = employeeList.stream()
				.filter(emp -> emp.getAge() < 30)
				.findFirst();
		if (firstEmpBelow30.isPresent()) {
			System.out.println("First employee below 30: " + firstEmpBelow30.get());
		}
	}
}
