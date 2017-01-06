package array;

public class RemPall {
int find(char[] a){
	if(a==null||a.length==0) return 0;
	int i,j,k,n=a.length,min=n;
	for(i=n/2-1;i<n;i++){
		for(j=i,k=i+1;k<n;j--,k++){
			if(a[j]==a[k]) min=j;
			else if(a[j]!=a[k]) break;
		}
	}
	for(i=n/2;i<n;i++){
		for(j=i-1,k=i+1;k<n;j--,k++){
			if(a[j]==a[k]) min=j;
			else if(a[j]!=a[k]) break;
		}
	}
	return min;
}
public static void main(String[] args) {
	String str="abcd";
	char[] ch=str.toCharArray();
	System.out.println(new RemPall().find(ch));
}
}
