package classesNobjects;
class Clidder {
	
	static String st = "sid";
	  void flipper() { 
		  System.out.println("Clidder"); }
}
public class Clidlet extends Clidder {
	public  void flipper() { System.out.println("Clidlet"); }
	public static void main(String [] args) {
//		Clidder cl = new Clidlet();
//		Clidlet c = (Clidlet)cl;
		//System.out.println(Clidder.E1.INSTANCE.ordinal());
	}
}
interface A76{
	public void m();
}