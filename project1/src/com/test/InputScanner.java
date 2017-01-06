package com.test;

import java.util.Scanner;

public class InputScanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		String[] sp = st.split("\\s");
		int a =Integer.parseInt(sp[0]);
		int b = Integer.parseInt(sp[1]);
		System.out.println(a+" "+b);
		sc.close();
	}
}
