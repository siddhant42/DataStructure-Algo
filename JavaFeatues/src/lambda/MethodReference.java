package lambda;

import java.time.LocalDate;
import java.util.*;

import model.Person;

class ComparisonProvider {
    public int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }
        
    public static int compareByAge(Person a, Person b) {
        return a.getBirthday().compareTo(b.getBirthday());
    }
    
    public static Set<Person> transfor(Person arr[],HashMap<String, Person> m){
    	return new TreeSet<Person>();
    }
}

public class MethodReference {

	public static void main(String args[]){
		Person p1=new Person("Dev",LocalDate.parse("1991-09-17"),"male");
		Person p2=new Person("Nit",LocalDate.parse("1993-10-14"),"male");
		Person p3=new Person("Rit",LocalDate.parse("1992-04-20"),"male");
		Person[] perArr={p1,p2,p3};
		System.out.println("**********Reference to a Static Method**************");
		Arrays.sort(perArr,ComparisonProvider::compareByAge);
		display(perArr);
		System.out.println("**********Reference to an Instance Method**************");
		ComparisonProvider myComparisonProvider = new ComparisonProvider();
		Arrays.sort(perArr,myComparisonProvider::compareByName);
		display(perArr);
		System.out.println("**********Reference to an Instance Method of an Arbitrary Object of a Particular Type**************");
		Arrays.sort(perArr,Person::compare);
		display(perArr);
		
	}
	
	public static void display(Person arr[]){
		for(Person p:arr){
			System.out.println(p);
		}
	}
	
	
}
