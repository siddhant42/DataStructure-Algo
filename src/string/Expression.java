package string;

import java.util.Stack;

public class Expression {
Stack<Character> s=new Stack<Character>();
private boolean check(String str){
	char[] a=str.toCharArray();
	for(int i=0;i<a.length;i++){
		if(a[i]=='['||a[i]=='{'||a[i]=='(')
			s.push(a[i]);
	
	else if(a[i]==')'){
		if(s.peek()=='(') s.pop();
		else return false;
	}
	else if(a[i]=='}'){
		if(s.peek()=='{') s.pop();
		else return false;
	}
	else if(a[i]==']'){
		if(s.peek()=='[') s.pop();
		else return false;
	}
	else continue;
}
return true;	
}
public static void main(String[] args) {
String str="[this]is{(a})not";
if(new Expression().check(str))
	System.out.println("correct");
else
	System.out.println("incorrect");
}
}
