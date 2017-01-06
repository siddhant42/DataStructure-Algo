package recursion;

public class PalPart {
	public static void main(String[] args) {
		String str="sudundnus";
		char[] ch=str.toCharArray();
		String[] data=new String[ch.length];
		String tmp="";
		new PalPart().find(ch,0,0,ch.length-1,data,tmp);
	}

	private void find(char[] str, int st, int idx,  int end, String[] data,String tmp) {
		if(st==str.length){
			int i=0,count=0;
			/*while(i<data.length && count <str.length){
				if(ispalindrome(data[i])==false)
					return;
				count+=data[i].length();
				i++;
			}
			i=0;count=0;*/
			while(i<data.length && count < str.length){
				System.out.print(data[i]+" ");
				count+=data[i].length();
				i++;
			}
			System.out.println();
			//System.out.println(String.valueOf(b));
			return;
		}
		for(int j=st;j<=end;j++){
			String newStr=String.valueOf(str).substring(st, j+1);
			data[idx]=newStr;
			if(ispalindrome(newStr))
			find(str,j+1,idx+1,end,data,newStr);
			//data[idx]=tmp;
			
			//System.out.println(tmp);
			//find(str,j+1,idx+1,end,data,newStr);
		}
	}

	private boolean ispalindrome(String st) {
		if(st==null || st.length()==0 || st.length() == 1)
			return true;
		char[] ch = st.toCharArray();
		int i=0,j=ch.length-1;
		while(i<=j){
			if(ch[i]!=ch[j])
				return false;
			i++;j--;
		}
		return true;
	}
}
