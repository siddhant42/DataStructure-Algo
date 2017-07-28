package lambda;

import java.util.*;
import java.util.stream.Collectors;

public class StreamClass {

	public static void main(String[] args) {
		// Count empty strings
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println("List: " + strings);
		
		long count = getCountEmptyStringUsingJava7(strings);
		System.out.println("Empty Strings in Java 7: " + count);
		count = strings.stream().filter(dev -> dev.isEmpty()).count();
		System.out.println("Empty Strings in Java 8: " + count);

		count = getCountLength3UsingJava7(strings);
		System.out.println("Strings of length 3 in java 7: " + count);
		count = strings.stream().filter(string -> string.length() == 3).count();
		System.out.println("Strings of length 3 in java 8: " + count);
		
		// Eliminate empty string
		List<String> filtered = deleteEmptyStringsUsingJava7(strings);
		System.out.println("Filtered List in java 7: " + filtered);
		filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered List in java 8: " + filtered);
		
		// Eliminate empty string and join using comma.
		String mergedString = getMergedStringUsingJava7(strings, ", ");
		System.out.println("Merged String in java 7: " + mergedString);
		mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
		System.out.println("Merged String in java 8: " + mergedString);

		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		// get list of square of distinct numbers
		List<Integer> squaresList = getSquares(numbers);
		System.out.println("Squares List in java 7: " + squaresList);
		squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println("Squares List in java 8: " + squaresList);
		List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
		System.out.println("*************Using Java 7:*************** ");
		System.out.println("List: " + integers);
		System.out.println("Highest number in List : " + getMax(integers));
		System.out.println("Lowest number in List : " + getMin(integers));
		System.out.println("Sum of all numbers : " + getSum(integers));

		System.out.println("*************Using Java 8:*************** ");
		IntSummaryStatistics stat = integers.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("Highest number in List : " + stat.getMax());
		System.out.println("Lowest number in List : " + stat.getMin());
		System.out.println("Sum of all numbers : " + stat.getSum());

	

		// print ten random numbers
		Random random = new Random();
		System.out.println("*************Using Java 7:*************** ");
		System.out.println("Random Numbers: ");
		for (int i = 0; i < 5; i++) {
			System.out.println(random.nextInt());
		}
		System.out.println("*************Using Java 8:*************** ");
		random.ints().limit(5).sorted().forEach(System.out::println);
	}

	private static int getCountEmptyStringUsingJava7(List<String> strings) {
		int count = 0;

		for (String string : strings) {

			if (string.isEmpty()) {
				count++;
			}
		}
		return count;
	}

	private static int getCountLength3UsingJava7(List<String> strings) {
		int count = 0;

		for (String string : strings) {

			if (string.length() == 3) {
				count++;
			}
		}
		return count;
	}

	private static List<String> deleteEmptyStringsUsingJava7(List<String> strings) {
		List<String> filteredList = new ArrayList<String>();

		for (String string : strings) {

			if (!string.isEmpty()) {
				filteredList.add(string);
			}
		}
		return filteredList;
	}

	private static String getMergedStringUsingJava7(List<String> strings, String separator) {
		StringBuilder stringBuilder = new StringBuilder();

		for (String string : strings) {

			if (!string.isEmpty()) {
				stringBuilder.append(string);
				stringBuilder.append(separator);
			}
		}
		String mergedString = stringBuilder.toString();
		return mergedString.substring(0, mergedString.length() - 2);
	}

	private static List<Integer> getSquares(List<Integer> numbers) {
		List<Integer> squaresList = new ArrayList<Integer>();

		for (Integer number : numbers) {
			Integer square = new Integer(number.intValue() * number.intValue());

			if (!squaresList.contains(square)) {
				squaresList.add(square);
			}
		}
		return squaresList;
	}

	private static int getMax(List<Integer> numbers) {
		int max = numbers.get(0);

		for (int i = 1; i < numbers.size(); i++) {

			Integer number = numbers.get(i);

			if (number.intValue() > max) {
				max = number.intValue();
			}
		}
		return max;
	}

	private static int getMin(List<Integer> numbers) {
		int min = numbers.get(0);

		for (int i = 1; i < numbers.size(); i++) {
			Integer number = numbers.get(i);

			if (number.intValue() < min) {
				min = number.intValue();
			}
		}
		return min;
	}

	private static int getSum(List numbers) {
		int sum = (int) (numbers.get(0));

		for (int i = 1; i < numbers.size(); i++) {
			sum += (int) numbers.get(i);
		}
		return sum;
	}

	private static int getAverage(List<Integer> numbers) {
		return getSum(numbers) / numbers.size();
	}

}
