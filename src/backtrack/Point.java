package backtrack;

public class Point{
	int x;
	int y;
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point){
			Point p=(Point) obj;
			return this.x==p.x && this.y==p.y;
		}
		return false;
	}
	public Point() {
		super();
	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
