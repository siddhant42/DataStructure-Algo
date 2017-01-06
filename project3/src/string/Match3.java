package string;

import java.util.regex.Pattern;


public class Match3 {

public static void main(String[] args) {
	//String p="abc";
	String reg="(abc)*";
	String s="abca";
	System.out.println(Pattern.matches(reg,s));
}
}
