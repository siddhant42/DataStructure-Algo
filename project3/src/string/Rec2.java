package string;

public class Rec2 {
public static void main(String[] args) {
	String s="abc";
	char[] p=s.toCharArray();
	int r=3;
	char[] ch=new char[r];
	
	new Rec2().printRec(p,s.length()-1,0,r,ch);
}
void printRec(char[] s,int end,int idx,int k,char[] str){
	if(k<=0||s.length==0||s==null){
		System.out.println("string is empty or length of string to print is not valid");
	}
	if(idx==k){
		for(int i=0;i<k;i++)
			System.out.print(str[i]);
		System.out.println();
	}
	else{
		for(int j=0;j<=end;j++){
			str[idx]=s[j];
			printRec(s,end,idx+1,k,str);
		}
	}
}
}
