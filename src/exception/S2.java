package exception;

public class S2 {
	public static void main (String [] args) {
		doStuff();
		System.out.println("line after exception");
		}
		static void doStuff() {
		doMoreStuff();
		}
		static void doMoreStuff() {
		int x = 5/0; // Can't divide by zero!
		// ArithmeticException is thrown here
		}
}
