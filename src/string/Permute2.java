package string;

public class Permute2 {
void swap(char[] s,int i,int j){
	char tmp=s[i];
	s[i]=s[j];
	s[j]=tmp;	
}
void permute(char[] s,int st,int end){
	if(s==null||s.length==0) return;
	if(st==end){
		System.out.print(String.valueOf(s)+" ");
	}
	else{
		for(int j=st;j<=end;j++){
			swap(s,st,j);
			permute(s,st+1,end);
			swap(s,st,j);
		}
	}
}
public static void main(String[] args) {
Permute2 obj=new Permute2();
char[] s="abc".toCharArray();
obj.permute(s, 0, s.length-1);

}}

