package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Regex {
	public static void main(String [] args) {
		//String pattern="\\d\\w";
		//String source="ab4 56_7ab";
		String p1="a?";
		String s2="baba";
		Pattern p = Pattern.compile(p1);
		Matcher m = p.matcher(s2);
		System.out.println("Pattern is " + m.pattern());
		while(m.find()) {
			System.out.println(m.start() + " " + m.end()+" "+m.group());
		}
	}
}
