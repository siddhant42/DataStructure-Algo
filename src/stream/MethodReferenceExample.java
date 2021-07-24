package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Function<String,Integer> fun = Integer::parseInt;
		Function<String,Integer> fun2 = str->Integer.parseInt(str);
		System.out.println("parse through MF "+fun.apply("90"));
		System.out.println("parse through lambda "+fun2.apply("80"));
		Consumer<String> stringPrinter=System.out::println;
		Consumer<String> stringPrinterLambda=(String s) -> System.out.println(s);
		stringPrinter.accept("Print from method reference based instance");
		stringPrinterLambda.accept("Print from instance created from Lambda");
		List<Integer> intList=Arrays.asList(1,2,3,4);
		BiPredicate<List<Integer>,Integer> isPartOf=List::contains;
		BiPredicate<List<Integer>,Integer> isPartOfLambda=(List<Integer> listInt, Integer value) -> listInt.contains(value);
		System.out.println("Is 1 a part of the intList - "+ isPartOf.test(intList, 1));
		System.out.println("Is 1 a part of the intList - "+ isPartOfLambda.test(intList, 1));

	}
}
