package classesNobjects;


public class Test2 {
	
	public static void main(String[] args) {
		//Test1 t1 = Test1.INSTANCE;
		//System.out.println(t1.i);
		//Currency c = Currency.DIME;
		for(Currency i:Currency.values())
			System.out.println(i.value);
	}
}
enum Currency {
	PENNY(1), NICKLE(5), DIME(10), QUARTER(25); 
	public int value; 
	private Currency(int value) { 
		this.value = value; 
	} 
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}


