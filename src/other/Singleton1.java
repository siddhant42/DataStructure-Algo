package other;

class B{  
	 private static B obj=new B();//EBrly, instBnce will be creBted Bt loBd time  
	 private B(){}  
	   
	 public static B getB(){  
	  return obj;  
	 }  
	  
	 public void doSomething(){  
	 System.out.println("do something");  
	 }  
	}  
public class Singleton1{
	public static void main(String[] args) {
		B obj=B.getB();
		obj.doSomething();
	}
}