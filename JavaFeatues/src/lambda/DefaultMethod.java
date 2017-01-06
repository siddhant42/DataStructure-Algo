package lambda;

interface Person{
	void getName();
	default void getAdress(){
		System.out.println("Delhi");
	}
	
	static void getState(){
		System.out.println("Delhi");
	}
}

interface Person2{
	void getName();
	default void getAdress(){
		System.out.println("Delhi2");
	}
	
	static void getState(){
		System.out.println("Delhi2222222");
	}
}
interface SubPerson extends Person{
	 void getAdress();
		
	
}

public class DefaultMethod implements Person,Person2{
  
  @Override public void getAdress() { // TODO Auto-generated method stub
	  Person2.super.getAdress();
	  Person.super.getAdress();
	  
  }
 
//public class DefaultMethod implements SubPerson{
//public class DefaultMethod implements Person{

	public void getName(){
		System.out.println("Devendar Yadav");
	}
	


	public static void main(String args[]){
		DefaultMethod dm=new DefaultMethod();
		dm.getName();
		dm.getAdress();
		Person.getState();
		
	}
}
