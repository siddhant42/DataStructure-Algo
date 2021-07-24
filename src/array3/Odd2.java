package array3;

import java.util.Arrays;

public class Odd2 {
	int i,n,x,y,cnt=1;
	int[] a={1,2,2,3,4,5,1,5};
	

public void find(){
	//System.out.println(a.length);
	n=a.length;
if(n<2){
	System.out.println("numbers are less");
return;}
else if(n==2){
	for(i=0;i<a.length;i++)
		System.out.println(a[i]);
}
else{
	Arrays.sort(a);
	for(i=1;i<n;i++){
		System.out.print(a[i]);
	
	}
	System.out.println();
	for(i=1;i<n;i++){
		if(a[i]==a[i-1]) cnt++;
		else{
			if(cnt%2!=0)
				System.out.println(a[i-1]);
			cnt=1;
		}
	}
}
}
public static void main(String[] args) {
	Odd2 o=new Odd2();
	o.find();
}
}
