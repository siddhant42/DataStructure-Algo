package exception;

import java.io.IOException;
import java.sql.SQLException;

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
	public void couldThrowAnException() throws SQLException, IOException{}
	public void rethrow() throws SQLException, IOException {
		try {
			couldThrowAnException();
		} catch (Exception e) {
			e = new IOException();
			//throw e;
		}
	}

}
class A extends MyException{}
class TestEx {

	void doStuff(){
		//throw new MyException(); // Throw a checked exception
	}
}





















