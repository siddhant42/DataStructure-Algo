package array;

public class Repeat {
	public int a[] = {1,2,2,1};
	int n=a.length-2,x,y,i,setBit,xor2;
	public void findRepeat(){
		//System.out.println(n);
		if(n<2){
			System.out.println("there are less no. of elements");
			return;
		}
		else if(n==2){
			x=1;y=2;
		}
		else{
		xor2=a[0];
		for(i=1;i<a.length;i++)
			xor2^=a[i];
		for(i=1;i<=n;i++)
			xor2^=i;
		setBit=xor2& ~(xor2-1);
		for(i=0;i<a.length;i++){
			if((setBit&a[i])!=0) x^=a[i];
			else y^=a[i];
		}
		for(i=1;i<=n;i++){
			if((setBit&i)!=0) x^=i;
			else y^=i;
		}}
		System.out.println(x+" "+y);
	}
	public static void main(String[] args) {
		Repeat obj=new Repeat();
		obj.findRepeat();
	}
}
