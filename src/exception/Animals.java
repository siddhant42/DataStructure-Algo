package exception;

import java.io.Closeable;
import java.io.IOException;

public class Animals {
	class Lamb implements Closeable {
		public void close() {
			System.out.println("after close block");
			throw new RuntimeException("a");
		} }
	public static void main(String[] args) {
		new Animals().run();
	}
	public void run() {
		try (Lamb l = new Lamb();) {
			System.out.println("after try block");
			throw new IOException();
		} 
		catch(Exception e) {
			System.out.println("after catch block");
			throw new RuntimeException("c");
		} } }
