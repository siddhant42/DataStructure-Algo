package recursion2;

public class Pallindrome {
int num;
boolean ispal(int n){
	if(n==0) return true;
	boolean isp=ispal(n/10);
	if(!isp) return false;
	//if(!ispal(n/10)) return false;
	if(num%10!=n%10) return false;
	else num/=10;
	return true;
}
public static void main(String[] args) {
	int n=123321;
	Pallindrome obj=new Pallindrome();
	obj.num=n;
	System.out.println(obj.ispal(n));
}
}
