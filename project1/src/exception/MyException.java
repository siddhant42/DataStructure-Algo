package exception;

class MyException extends Exception {

	private static final long serialVersionUID = 1L;
	void someMethod () throws MyException {
		doStuff();
	}
	void doStuff() throws MyException {
		try {
			throw new MyException();
		}
		catch(MyException me) {
			throw me;
		}
	}
}
class A extends MyException{}
class TestEx {
	
void doStuff(){
//throw new MyException(); // Throw a checked exception
}
}