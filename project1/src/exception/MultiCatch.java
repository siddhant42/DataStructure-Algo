package exception;

public class MultiCatch {
	public void m1(){
		try{
			int n=5;
		}catch(ArithmeticException|ArrayStoreException e){}
	}
}
