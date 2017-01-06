package array;

public class Odd {
int i,n,x=0,y=0,setBit,xor2,z;
int[] a=
		{1,2,2,3,4,5,1,5};
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
	xor2=a[0];
	for(i=1;i<a.length;i++){
		xor2^=a[i];}
		setBit=xor2&(~(xor2-1));
		for(i=0;i<a.length;i++){
			z=(setBit & a[i]);
			if(z!=0)
				x^=a[i];
			else
				y^=a[i];
		}
	

System.out.println("two numbers having odd no. of occurences are "+x+" and "+y);
}}
public static void main(String[] args) {
	Odd o=new Odd();
	o.find();
}
}
