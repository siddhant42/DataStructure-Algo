package string;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Match2 {
	public static void main(String[] args) {
Pattern p=Pattern.compile("[abc]s");
Matcher m=p.matcher("as");
boolean b=m.matches();
boolean c=Pattern.matches("[abc]", "sa");
System.out.println(b);
System.out.println(c);
}}
