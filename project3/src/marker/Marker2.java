package marker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Marker2 implements Serializable{
int id;
String name;
public Marker2() {
	System.out.println("p");
}
public Marker2(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
void m(){
	System.out.println("this is method m");
}

@Override
public String toString() {
	return "Marker2 [id=" + id + ", name=" + name + "]";
}
public static void main(String[] args) throws Exception{
	Marker2 m1=new Marker2();
	FileOutputStream out=new FileOutputStream("f.txt");
	ObjectOutputStream fout=new ObjectOutputStream(out);
	fout.writeObject(m1);
	fout.flush();
	ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
	Marker2 m2=(Marker2)in.readObject(); 
	// A new way of creating object without calling new keyword and constructor call
	//m2.m();
	System.out.println(m1==m2);
	System.out.println(m1.equals(m2));
	//System.out.println(m2);
}
}
