package lambda;

interface MathOperation {
    int operation(int a, int b);
 }
	
 interface GreetingService {
    void sayMessage(String message);
 }
 
public class LambdaExprss {

	public static void main(String args[]){
		LambdaExprss le=new LambdaExprss();
		MathOperation add= (int a,int b)-> a+b;  // with type declaration
		MathOperation subs=(a,b)-> a-b;   // without type delaration
		MathOperation mult=(a,b)-> {return a*b;}; // with curly braces
		MathOperation div=(a,b) -> a/b;  // without curly braces
		
		System.out.println("addition "+le.operate(1, 3, add));
		System.out.println("substract "+le.operate(1, 3, subs));
		System.out.println("multiple "+le.operate(1, 3, mult));
		System.out.println("divide "+le.operate(1, 3, div));
		
	}
	
	public int operate(int a,int b,MathOperation operate){
		return operate.operation(a, b);
	}
}
