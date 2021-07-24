package other;
class A{  
	 private static A obj;  
	 private A(){}  
	   
	 public static A getA(){  
	   if (obj == null){  
	      synchronized(A.class){  
	        if (obj == null){  
	            obj = new A();//instance will be created at request time  
	        }  
	    }              
	    }  
	  return obj;  
	 }  
	  
	 public void doSomething(){  
	 System.out.println("so something method"); 
	 }  
	}
public class C {
	public static void main(String[] args) {
		A obj=A.getA();
		obj.doSomething();
	}
}
