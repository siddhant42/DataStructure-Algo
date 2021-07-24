package other;

import java.util.Scanner;

public class AssertionExample {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter an age value");
	int value=sc.nextInt();
	assert value>=18:"Not Valid";
	System.out.println("value is "+value);
}
}
