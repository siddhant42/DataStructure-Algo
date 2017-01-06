package exception;

import java.io.IOException;
import java.sql.SQLException;

public class Test {
	class RanOutOfTrack extends Exception { }
	class AnotherTrainComing extends Exception { }
	public static void main(String[] args) throws RanOutOfTrack,AnotherTrainComing {
	Test a = new Test();
	try {
	a.drive();
	System.out.println("honk! honk!");
	} catch(RanOutOfTrack|AnotherTrainComing e){
	System.out.println("error driving");
	throw e;
	}
	}
	void drive() throws RanOutOfTrack, AnotherTrainComing {
	throw new RanOutOfTrack();
	}
}
