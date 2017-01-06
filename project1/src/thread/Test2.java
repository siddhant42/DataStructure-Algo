package thread;

public class Test2 implements Runnable {
	int i;
	@Override
	public void run() {
		for(i=0;i<=100;i++){
		System.out.print(i+" ");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.println();
	}
public static void main(String[] args) {
	Test2 obj = new Test2();
	Thread t1 = new Thread(obj);
	Thread t2 = new Thread(obj);
	t1.start();
	t2.start();
}
}
