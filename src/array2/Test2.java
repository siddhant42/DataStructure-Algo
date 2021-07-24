package array2;

import java.util.HashSet;

public class Test2 {
	static class Point{
		int x,y;
        public Point(){}
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
        public boolean equals(Object obj) {
            Point p = (Point)obj;
            return this.x==p.x && this.y==p.y;            
        }
        public int hashCode() {
        	return x+y;
        }
    }
	public static void main(String[] args) {
		HashSet<Point> set = new HashSet<>();
		set.add(new Point(1,2));
		set.add(new Point(1,2));
		System.out.println(set.size());
		System.out.println(set.contains(new Point(1,2)));
	}
}
