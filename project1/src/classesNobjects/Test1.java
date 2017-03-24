package classesNobjects;
/**
 * 1. All enums by default extends java.lang.Enum class making 
 * it not extend to any other class
 * 2. Neither enums can extend any other class explicitly
 * nor any other class can extend any enums - because enums
 * have private constructors making it difficult to call super
 * constructors in subclasses
 * 3. enums although can implement interfaces as like normal
 * java class it has to give implementations of the interfaces methods
 * In case it doesn't give implementation of the interface method
 * it can mark that method as abstract but in that case all the
 * enum constants will have to give implementations for that method.
 * because any abstract methods created inside the enum must be 
 * overriden/implemented by all of its enum constants.
 * 4. enums can be used in switch and case statements
 * 5. Allowed Access Modifiers- public
 * @author Siddhant Kumar
 *
 */
public enum Test1 implements I2 {
	// these are like public static final objects of enum(Test1) class
	// these constants should be first line inside an enum and Also, 
	// when there are fields and methods, the list of enum constants 
	// must end with a semicolon, which can be absent in absense of 
	// fields & methods
	INSTANCE(10) {
		@Override
		public void m2() {
			System.out.println("Inside Test1.Instance");
			
		}
	},INSTANCE2(12) {
		@Override
		public void m2() {
			System.out.println("Inside Test1.instance2");
			
		}
	};
	// The enum Test1 already defines the method values() implicitly
/*	public Test1[] values() {
		
	}*/
	private int i;
	Test1(int i){
		this.i=i;
	}
	/*public void m2() {
		System.out.println("Inside Test1.m2()");
	}*/
	public abstract void m2();
	public static void main(String[] args) {
		Test1 t1 = Test1.INSTANCE;
		t1.m2();
		System.out.println(t1.i);
		System.out.println(Test1.values().length);
		for(Test1 t:Test1.values()){
			System.out.println(t.i);
		}
	}
}
interface I2 {
	void m2();
}
// You can't create a class with same name as of enums within the access zone of enum
// shows that enums are also a type of classS
//class Test1 {}
/*class Test2 {
	static Test1 t121;
	
}*/


















