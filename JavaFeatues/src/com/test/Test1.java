package com.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
interface I1{
	public String toString();
	public static void m1(){
		System.out.println("inside m1 of I1");
	}
}
interface I2{
	public static void m1(){
		System.out.println("inside m1 of I2");
	}
}
public class Test1 implements I1,I2 {
	public static void main(String[] args) {
		/*Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(5);
		set.add(15);
		set.add(6);
		set.add(3);
//		Iterator<Integer> itr = set.iterator();
//		while(itr.hasNext())
//			System.out.println(itr.next());
		set.forEach(new Consumer<Integer>(){

			@Override
			public void accept(Integer i) {
				System.out.println(i);
				
			}
			
		});
		I1 obj = new Test1();
		System.out.println(obj.toString());*/
		I1 obj = new Test1();
		//obj.m1();
	}
}
