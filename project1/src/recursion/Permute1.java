package recursion;

public class Permute1 {
	public static void main(String[] args) {
		String str = "abcd";
		char[] data = new char[str.length()];
		new Permute1().find(str,0,str.length(),data);
	}

	private void find(String str, int idx, int end, char[] data) {
		if(idx==end){
			System.out.println(String.valueOf(data));
			return;
		}
	for(int i=0;i<str.length();i++){
		data[idx] = str.charAt(i);
		find(str.substring(0,i)+str.substring(i+1,str.length()),idx+1,end,data);
	}
	}
}
