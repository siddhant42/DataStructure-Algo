package string;

public class Rec1 {
public int countA(String s){
	if(s.isEmpty()||s.length()==0)
		return 0;
	//if(s.equals("A")) return 1;
	if(s.charAt(0)=='A')
		return 1+countA(s.substring(1));
	else 
		return countA(s.substring(1));
}
public static void main(String[] args) {
	String s="AAA rating";
	int n=new Rec1().countA(s);
	System.out.println(n);
	
}
}
