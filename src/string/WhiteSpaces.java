package string;

import java.util.Arrays;
import java.util.List;

public class WhiteSpaces {
	public void print(String abc){
		String regex="[,\\s]+";
List<String> list=Arrays.asList(abc.split(regex));
for(String word:list){
	System.out.print(word+" ");
	//System.out.print(" ");
}
	}
public static void main(String[] args) {
	WhiteSpaces obj=new WhiteSpaces();
	String abc="this,     is          it";
	obj.print(abc);
	
}
}
