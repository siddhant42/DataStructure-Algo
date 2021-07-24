package array3;

import java.util.Scanner;

public class Median {
	public char ch;
	//public int number,n;
public int a[]=new int[100],i=0;
public void findMedian(int number,int n){
	int tmp,mid,median;
	a[i++]=number;
	if(n==1){
		System.out.println("median is "+number);
		return;
	}
	for(int i=n-1;i>0;i--){
		if(a[i]>a[i-1]){
			tmp=a[i];
			a[i]=a[i-1];
			a[i-1]=tmp;
		}
	}
	mid=n/2;
	if(n%2==0)
		median=(a[mid]+a[mid-1])/2;
	else median=a[mid];
	System.out.println("median of the given inputs is "+median);
}
public static void main(String[] args) {
	Median m=new Median();
	int number,cnt=0;
	char ch;
	do{
	System.out.println("enter any integer\n");
	Scanner sc=new Scanner(System.in);
	number=sc.nextInt();
	cnt++;
	m.findMedian(number,cnt);
	System.out.println("do you want to continue");
	ch=sc.next().charAt(0);
	}while(ch=='y'||ch=='y');
}
}
