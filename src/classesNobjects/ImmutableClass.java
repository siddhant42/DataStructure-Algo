package classesNobjects;
// Make your class final, so that no other classes can extend it.
final class Abc{
	// It should be private and final so that 
	// they’re initialized only once inside the 
	// constructor and never modified afterward.
	private final StringBuilder sb;
	// make sure to use a clone copy of the passed argument and 
	// never set your mutable field to the real instance passed through constructor
	public Abc(StringBuilder sb) {
		this.sb = new StringBuilder(sb);
	}
	// Make sure to always return a clone copy of the field and 
	// never return the real object instance
	public StringBuilder getSb() {
		return new StringBuilder(sb);
	}
	// Don’t expose setter methods.

}
public class ImmutableClass {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("sid");
		Abc obj = new Abc(sb);
		System.out.println(obj.getSb());
		//sb = new StringBuilder("siddhant");
		obj.getSb().append("dhant");
		sb.append("dhant");
		System.out.println(obj.getSb());
	}
}
