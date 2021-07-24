package dynamicprog;

public class Uglino {
public static void main(String[] args) {
	int n=15;
	System.out.println(new Uglino().find(n));
}
int find(int n){
	int[] ugly=new int[n];
	int i2=0,i3=0,i5=0,nextuglyno=0;
	ugly[0]=1;
	for(int i=1;i<n;i++){
		nextuglyno=min(ugly[i2]*2,ugly[i3]*3,ugly[i5]*5);
		//System.out.println(ugly[i2]+" "+ugly[i3]+" "+ugly[i5]);
		//System.out.println(nextuglyno);
		//System.out.println();
		if(nextuglyno==ugly[i2]*2){
			i2+=1;
			ugly[i]=nextuglyno;
		}
		if(nextuglyno==ugly[i3]*3){
			i3+=1;
			ugly[i]=nextuglyno;
		}
		if(nextuglyno==ugly[i5]*5){
			i5+=1;
			ugly[i]=nextuglyno;
		}
	}
	return nextuglyno;
}
int min(int a,int b,int c){
	if(a<b&&a<c) return a;
	else 
		return b<=c?b:c;
}
}
