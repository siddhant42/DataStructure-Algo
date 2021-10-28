package classesNobjects;

import java.util.Arrays;
/**
 * This class demonstrates that if we clone an array of any Objects
 * then it will create a deep copy of that object array
 * @author siddhant
 *
 */
public class Clone3 implements Cloneable {

	private Object[] objects;
	public Clone3(Object[] objects) {
		this.objects = objects;
	}
	public Clone3 clone() throws CloneNotSupportedException {
		Clone3 obj = (Clone3)super.clone();
		obj.objects = objects.clone();
		return obj;
	}
	public static void main(String[] args) throws Exception {
		Object[] objects = new Object[2];
		objects[0] = "Siddhant1";
		objects[1] = "Siddhant2";
		Clone3 obj1 = new Clone3(objects);
		Clone3 obj2 = obj1.clone();
		obj2.objects[0] = "Siddhant3";
		Arrays.stream(obj1.objects).forEach(System.out::println);
	}

}
