package lambda;

interface Calculate{
	public int doCal(int a,int b);
}
public class MethodReference2 {

	public int doOperation(int i,int j){
		return i+j;
	}
	public static void main(String[] args) {
		MethodReference2 meth=new MethodReference2();
		Calculate cal=meth::doOperation;
		System.out.println("Sum of the number is "+cal.doCal(4, 7));

	}

}
