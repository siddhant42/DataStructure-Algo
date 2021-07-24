package string;

public class Match1 {
public static void main(String[] args) {
	String str="welcome to homeland";
	System.out.print("return value: ");
	System.out.println(str.matches("(.*)homeland(.*)"));
}
}
