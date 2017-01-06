package recursion;

public class Pallindrome2 {
	boolean ispal(int n){
		String str=n+"";
		char[] ch=str.toCharArray();
		return ispalRec(ch,0,ch.length-1);
	}
	boolean ispalRec(char[] ch,int low,int high){
		if(low<=high){
			if(ch[low]!=ch[high]) return false;
			return ispalRec(ch,low+1,high-1);
		}
		return true;
	}
public static void main(String[] args) {
	int n=12321;
	System.out.println(new Pallindrome2().ispal(n));
}
}
