package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PeekingInStreams {
	public static void main(String[] args) {
		Stream.iterate(1,n->n+1).peek(n->System.out.println("number generated: - "+n)).filter(n->n%2==0).peek(n->System.out.println("Even number filter passed for - "+n)).limit(5);
		IntStream.range(1, 10).peek(n->System.out.println("number generated: - "+n)).filter(n->n%2==0).peek(n->System.out.println("Even number filter passed for - "+n)).count();
	}
}
