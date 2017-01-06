package bit;

public class Power {
	public static void main(String[] args) {
		int n =0;
		System.out.println(new Power().isPow(n));
	}

	private  boolean isPow(int n) {
		if(n<=0) return false;
		int count = 0;
		while(n>0){
			if((n&1) != 0) count++;
			if(count>1) return false;
			n=n>>1;
			
		}
		return true;
	}
	
}
