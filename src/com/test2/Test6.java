package com.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
interface S12{
	void m1(int s);
}
interface Interface1 {

	void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}
	
	//trying to override Object method gives compile time error as
	//"A default method cannot override a method from java.lang.Object"
	
//	default String toString(){
//		return "i1";
//	}
	
}
public class Test6{
	/*public static int findSquareOfMaxOdd(List<Integer> numbers) {
		return numbers.stream()
				.filter(NumberTest::isOdd) 		//Predicate is functional interface and
				.filter(NumberTest::isGreaterThan3)	// we are using lambdas to initialize it
				.filter(NumberTest::isLessThan11)	// rather than anonymous inner classes
				.max(Comparator.naturalOrder())
				.map(i -> i * i)
				.get();
	}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}
	
	public static boolean isGreaterThan3(int i){
		return i > 3;
	}
	
	public static boolean isLessThan11(int i){
		return i < 11;
	}*/
	private static int sumStream(List<Integer> list) {
		return list.stream().filter(i -> i > 0).mapToInt(i->i).sum();
	}
	public static boolean isPrime(int num) {
	
		IntPredicate predicate = index -> num%index==0;
		return num>1 && IntStream.range(2, num).noneMatch(predicate);
		
	}
	public static void main(String[] args) {
		int n = 101;
		//System.out.println(isPrime(n));
//		Interface1 obj = (String b) -> System.out.println(b);
//		obj.method1(null);
		//int t = "abc"::length();
		List<Integer> list = Arrays.asList(1,2,3,4,5);
//		System.out.println(sumStream(list));
//		List<Integer> myList = new ArrayList<>();
//		for(int i=0; i<100; i++) myList.add(i);
//		Stream<Integer> sequentialStream = myList.stream();
//
//		Stream<Integer> highNums = sequentialStream.filter(p -> p > 90); //filter numbers greater than 90
//		System.out.print("High Nums greater than 90=");
//		highNums.forEach(p -> System.out.print(p+" "));
//		Stream<String> names = Stream.of("aBc", "d", "ef");
//		System.out.println(names.map(s ->s.toUpperCase()).collect(Collectors.toList()));
		list.stream().forEach(System.out::println);
	}
	
}
