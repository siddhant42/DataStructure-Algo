package recursion;

public class TOH {
	public static void main(String[] args) {
		int n=3;
		String s="sourcePole",a="auxilaryPole",d="destinationPole";
		new TOH().moveRec(s,d,a,n);
	}
	void moveRec(String s,String d,String a,int k){
		if(k<=0) return;
		moveRec(s,a,d,k-1);
		//System.out.println(s+" "+d+" "+a+" "+k);
		System.out.println("move disk "+k+" from "+s+" to "+d);
		moveRec(a,d,s,k-1);
	}
}
