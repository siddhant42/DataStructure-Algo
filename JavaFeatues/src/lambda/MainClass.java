package lambda;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
import java.util.TreeSet;

import model.Person;
import model.PersonComparator;

public class MainClass {

	public static void main(String args[]){
		Person p1=new Person("Dev",LocalDate.parse("1991-09-17"),"male");
		Person p2=new Person("Nit",LocalDate.parse("1993-10-14"),"male");
		Person p3=new Person("Rit",LocalDate.parse("1992-04-20"),"male");
		
		Person[] perArr={p1,p2,p3};
		Arrays.sort(perArr,new PersonComparator());
		display(perArr);
		System.out.println("***********Using Lamba*************");
		Arrays.sort(perArr,
			    ( a,  b) -> {
			    	return a.birthday.compareTo(b.birthday);
			    }
			);
		display(perArr);
	
	Arrays.sort(perArr,(a, b) -> Person.compare(a,b));
	display(perArr);
		
		//System.out.println("**********Using Method reference*********");
		//Arrays.sort(perArr,Person::compare);
		//display(perArr);
	}
	
	public static void display(Person arr[]){
		for(Person p:arr){
			System.out.println(p);
		}
	}
	
}
