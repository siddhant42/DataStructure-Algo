package stack;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Waiter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m =sc.nextInt();
		int n = sc.nextInt();
		//LinkedList<Integer> flist = new LinkedList<>();
		Stack<Integer> flist = new Stack<>();
		for(int i=0;i<m;i++)
			flist.push(sc.nextInt());		
		sc.close();
        int[] primes = getPrimes(n);
		find(flist,primes,0);
	}

private static  void find(Stack<Integer> flist, int[] primes,int st) {
		if(st==primes.length){
			while(flist.empty()==false)
				System.out.println(flist.pop());
			return;
		}
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		while(flist.empty()==false){
			int p = flist.pop();
			if(p%primes[st]==0) s2.push(p);
			else s1.push(p);
		}
		while(s2.empty()==false)
			System.out.println(s2.pop());
		find(s1,primes,st+1);
	}

	/*	private void find(LinkedList<Integer> flist,int m,int n) {
		int[] primes = getPrimes(n);
		LinkedList<Integer> sublist = null;
		LinkedList<LinkedList<Integer>> list = new LinkedList<>();
		for(int i=0;i<n;i++){
			sublist = new LinkedList<>();
            if(i%2==0){
                for(int j=flist.size()-1;j>=0;j--){
				if(flist.get(j)%primes[i]==0)
					sublist.push(flist.remove(j));
            }
            }
                else{
			for(int j=flist.size()-1;j>=0;j--){
				if(flist.get(j)%primes[i]==0)
					sublist.add(flist.remove(j));
            }}
			list.add(sublist);
		}
		list.add(flist);
		for(int i=0;i<list.size();i++){
			LinkedList<Integer> ll = list.get(i);
			for(int j:ll)
				System.out.println(j);
		}
	}*/
	private static int[] getPrimes(int n) {
		int[] primes = new int[n];
		int count=0;
		boolean flag=true;
		primes[count++]=2;
		for(int i=3;i<Integer.MAX_VALUE;i++){
			if(count==n) return primes;
			flag = true;
			for(int j=0;j<count;j++){
				int p = primes[j];
				if(p*p<=i && i%p==0){
					flag = false;
					break;
				}
			}
			if(flag) primes[count++]=i;
		}
		return primes;
	}
}
