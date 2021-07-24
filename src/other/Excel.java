package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Excel {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("entery any number");
	int n=sc.nextInt();
	System.out.println("equivalent excel no. is ");
	new Excel().find(n);
}
void find(int n){
	if(n<0) return;
	if(n==0){
		System.out.println('a');
	return;	
	}
char[] c=new char[100];
int j=0;
while(n>0){
	if(j==0)
		c[j++]=(char)((n%26)+97);
	else
	c[j++]=(char)((n%26)+96);
	n=(n)/26;
}
reverse(c,j);
printdata(c,j);
}
void reverse(char[] c,int n){
	char tmp;
	int i,j;
	for(i=0,j=n-1;i<j;i++,j--){
		tmp=c[i];
		c[i]=c[j];
		c[j]=tmp;
	}
}
void printdata(char[] c,int n){
	for(int i=0;i<n;i++)
		System.out.print(c[i]);
}
}
