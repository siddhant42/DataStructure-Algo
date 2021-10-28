package classesNobjects;

import java.util.Arrays;
/**
 * This class demonstrates that if we clone an array of any Objects
 * then it will create a deep copy of that object array but will not
 * create deep copy for attributes of that object
 * @author siddhant
 *
 */
public class Clone2 implements Cloneable {

	private Employee[] employee;
	public Clone2(Employee[] employee) {
		this.employee = employee;
	}
	public Clone2 clone() throws CloneNotSupportedException {
		Clone2 obj = (Clone2)super.clone();
		// It will not work. For this to work, make
		// a deep copy of attributes of employee as well.
//		obj.employee = employee.clone();
		// making a deep copy of employees
		obj.employee = new Employee[this.employee.length];
		for(int i=0;i<this.employee.length;i++) {
			obj.employee[i] = new Employee(this.employee[i].getName());
		}
		return obj;
	}
	public static void main(String[] args) throws Exception {
		Employee[] emplist = new Employee[2];
		emplist[0] = new Employee("Siddhant1");
		emplist[1] = new Employee("Siddhant2");
//		Employee[] emplist2 = emplist.clone();
		Clone2 obj = new Clone2(emplist);
		Clone2 obj2 = obj.clone();
		obj2.employee[0].setName("Siddhant3");
//		emplist2[0].setName("Siddhant3");
		Arrays.stream(obj.employee).forEach(System.out::println);
		
	}

}
