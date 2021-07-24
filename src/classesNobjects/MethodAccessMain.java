package classesNobjects;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;

public class MethodAccessMain {

	private static void withReflectionArgs() {
		Method meth = MethodAccessExampleWithArgs.makeMethod();

		MethodAccessExampleWithArgs mh0 = new MethodAccessExampleWithArgs(0);
		MethodAccessExampleWithArgs mh1 = new MethodAccessExampleWithArgs(1);
		try {
			System.out.println("Invocation using Reflection");
			meth.invoke(mh0, 5, "Jabba the Hutt");
			meth.invoke(mh1, 7, "Boba Fett");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void withMhArgs() {
		MethodHandle mh = MethodAccessExampleWithArgs.makeMh();
		MethodAccessExampleWithArgs mh0 = new MethodAccessExampleWithArgs(0);
		MethodAccessExampleWithArgs mh1 = new MethodAccessExampleWithArgs(1);
		try {
			System.out.println("Invocation using Method Handle");
			mh.invokeExact(mh0, 42, "R2D2");
			mh.invokeExact(mh1, 43, "C3PO");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		withReflectionArgs();
		withMhArgs();
	}
}
