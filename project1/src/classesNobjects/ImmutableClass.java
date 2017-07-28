package classesNobjects;
final class Abc{
	private final StringBuilder sb;
	public Abc(StringBuilder sb) {
		this.sb = new StringBuilder(sb);
	}
	public StringBuilder getSb() {
		return sb;
	}

}
public class ImmutableClass {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("sid");
		Abc obj = new Abc(sb);
		System.out.println(obj.getSb());
		//sb = new StringBuilder("siddhant");
		sb.append("dhant");
		System.out.println(obj.getSb());
	}
}
