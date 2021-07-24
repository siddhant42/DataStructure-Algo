package string;

public class MinWindow {
void find(String str,String ptr){
		if(str.isEmpty()||ptr.isEmpty())
		 return;
		char[] s=str.toCharArray();
		char[] p=ptr.toCharArray();
		int stidx=0,endidx=0,begin=0,end,i,cnt=0,minwindow=Integer.MAX_VALUE;
		int[] needtofind=new int[256];
		int[] hasfound=new int[256];
		int m=ptr.length(),n=str.length();
		for(i=0;i<256;i++){
			needtofind[i]=0;
			hasfound[i]=0;
		}
		for(i=0;i<m;i++){
			needtofind[p[i]]++;
			}
		for(end=0;end<n;end++){
			if(needtofind[s[end]]==0) continue;
			hasfound[s[end]]++;
			if(hasfound[s[end]]<=needtofind[s[end]]) cnt++;
			if(cnt==m){
				while(needtofind[s[begin]]==0||hasfound[s[begin]]>needtofind[s[begin]]){
					if(hasfound[s[begin]]>needtofind[s[begin]]){
						hasfound[s[begin]]--;
					}
					begin++;
				}
				if(minwindow>end-begin+1){
					
				stidx=begin;
				endidx=end;
				minwindow=end-begin+1;
				}
			}
		}
		if(cnt==m){
			System.out.println(minwindow);
			for(i=stidx;i<=endidx;i++)
				System.out.print(s[i]);			
		}		else{
			System.out.println("no such substring is found");
			return;}
	}
public static void main(String[] args) {
	String str="abfugtbaecab";
	String ptr="cab";
	new MinWindow().find(str,ptr);
}
}