package exception;

import java.io.Closeable;
import java.io.IOException;

public class Animals {
	class Lamb implements Closeable {
		public void close() {
			throw new RuntimeException("a");
		} }
	public static void main(String[] args) {
		new Animals().run();
	}
	public void run() {
		try (Lamb l = new Lamb();) {
			throw new IOException();
		} catch(Exception e) {
			throw new RuntimeException("c");
		} } }
