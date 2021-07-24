package string;

public class SplitImpl {
public static void main(String[] args) {
	String s1="this,is a , hello\tmy,name";
	String regex="[,\\s]+";
	String[] s2=s1.split(regex);
	for(String s:s2)
		System.out.println("string=\""+s+"\"");
}
}
