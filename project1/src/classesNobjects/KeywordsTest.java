package classesNobjects;
/**
 * outer class can only have following keywords specifiers available:
 * public,(abstract/final)
 * Not allowed keywords:-
 * private,protected,default,static,synchronized,transient,volatile,strictfp
 * @author Siddhant Kumar
 *
 */
public class KeywordsTest {
	/**
	 * Allowed keyword for constructor:-
	 * public, protected & private
	 */
	public KeywordsTest() {

	}
	/**
	 * Allowed keywords for class variables:-
	 * private,protected,public,static,final,transient,volatile,primitive & class data types
	 * Not Allowed keywords:-
	 * native,synchronized,abstract,strictfp,default
	 */
	private transient static final String name="Siddhant";
	/**
	 * Allowed keywords for class methods:-
	 * public, protected, private, abstract, static, final, synchronized, native & strictfp
	 * Not allowed keywords:-
	 * volatile,default,transient
	 */
	public static final void method(){
		/**
		 * Allowed keywords for method variable:-
		 * final
		 */
		final int x = 10;
		/**
		 * Allowed keywords for class inside a method
		 * abstract,final
		 */
		final class ClassInsideMethod {

		}
		System.out.println("inside class Method");
	}
	/**
	 * Allowed keywords for inner class:-
	 * public, protected, private, abstract, static & final
	 * Not allowed keywords:-
	 * transient,volatile,native,synchronized,strictfp,default
	 */
	private static final class InnerClass {

	}
	public static void main(String... args) {
		System.out.println("main method");
	}
}
interface In {
	/**
	 * Allowed keywords for interface methods:-
	 * public, (abstract/ default/ static) and strictfp
	 */
	public default void m1(){

	};
}
abstract class Abs{
	/**
	 * Allowed keywords for abstract class:-
	 * public, protected,abstract
	 */
	protected abstract void m();
}



















