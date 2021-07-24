package recursion;

public class Permute2 {
	public static void main(String[] args) {
		String str = "abcde";
		String tmp = "";
		new Permute2().find(str,0,str.length(),tmp);
	}

	private void find(String str, int idx, int end, String tmp) {
		if(idx==end){
			System.out.println(tmp);
			return;
		}
	for(int i=0;i<str.length();i++){
		String newTmp = tmp+str.charAt(i);
		find(str.substring(0,i)+str.substring(i+1,str.length()),idx+1,end,newTmp);
	}
	}
}
