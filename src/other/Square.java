package other;

public class Square {
public static void main(String[] args) {
	int n=25;
	System.out.println(new Square().find(n));
}
int find(int n){
	if(n==0) return 1;
	int m=(int)Math.sqrt(n);
	int i,j,ways=0;
	for(i=0;i<m;i++){
		for(j=i+1;j<=m;j++)
			if((i*i)+(j*j)==n)
			ways++;
	}
	return ways;
}
}
