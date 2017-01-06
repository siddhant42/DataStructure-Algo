package other;
class Mygen<T>{
	T obj;
	void add(T obj){
		this.obj=obj;
	}
	T get(){
		return obj;
	}
}
public class TestGeneric {
public static void main(String[] args) {
	Mygen<Integer> m=new Mygen<Integer>();
	m.add(5);
	m.add(7);
	System.out.println(m.get());
}
}
