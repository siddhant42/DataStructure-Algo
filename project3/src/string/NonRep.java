package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class NonRep {
	HashSet<Character> hs=new HashSet<Character>();
	HashSet<Character> print(char c){
		hs.add(c);
		return hs;
	}
	public static void main(String[] args) {
	char ch,c;
	HashSet<Character> p=new HashSet<Character>();
	NonRep obj=new NonRep();
	Scanner sc=new Scanner(System.in);
	do{
		System.out.println("enter any character");
		c=sc.nextLine().charAt(0);
		p=obj.print(c);
		System.out.println("nonrepeated characters area");
		for(char ct:p){
				System.out.print(ct);
		}
		System.out.println();
		System.out.println("do you want to continue ");
	ch=sc.nextLine().charAt(0);	
	}while(ch=='Y'||ch=='y');
}
}
