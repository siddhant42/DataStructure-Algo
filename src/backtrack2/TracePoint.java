package backtrack2;

import java.util.ArrayList;
import java.util.List;

public class TracePoint {
static class Point{
	int x,y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Point){
			Point p=(Point)o;
			if(p.x==this.x && p.y==this.y)
				return true;
		}
		return false;
	}
	
}
int[] row_x={-1,0,1};
int[] col_y={1,1,1};
int m=5,n=5;
//Point st;
int min=Integer.MAX_VALUE;
List<Point> minlist=new ArrayList<>();
List<Point> list=new ArrayList<>();
void find(char[][] a,Point s,Point e){
	int next_x,next_y;
	if(a==null||s==null||e==null||a.length==0)
		return;
	//System.out.println(s.x+" "+s.y);
	if(s.equals(e)){
		for(Point p:list){
			System.out.println(p.x+","+p.y);
		}
System.out.println();
		//System.out.println(s.x+" "+s.y);
		if(min>list.size()){
			min=list.size();
			//System.out.println(list);
			minlist=list;
			list.clear();
		}
		return;
	}
	for(int k=0;k<row_x.length;k++){
		next_x=s.x+row_x[k];
		next_y=s.y+col_y[k];
		if(isValid(a,s,next_x,next_y)){
			//System.out.println(next_x+" "+next_y);
			s.x=next_x;
			s.y=next_y;
			list.add(s);
			find(a,s,e);
			if(list.isEmpty()==false)
				list.remove(s);
			//System.out.println(s.x+" "+s.y);
		s.x-=row_x[k];
		s.y-=col_y[k];
		
	}}
	return;
}
boolean isValid(char[][] a,Point s,int next_x,int next_y){
	if(next_x<0||next_x>=m) return false;
	if(next_y<0||next_y>=n) return false;
	if(a[next_x][next_y]=='x'||a[next_x][next_y]=='S') 
		return false;
	return true;
}
public static void main(String[] args) {
	TracePoint obj=new TracePoint();
	char[][] a={
			{'1','1','1','1','1'},
			{'S','x','1','x','1'},
			{'1','1','1','1','1'},
			{'x','1','x','1','E'},
			{'1','1','1','1','1'}
	};
	Point start=new Point(1,0);
	Point end=new Point(3,4);
	//obj.st=start;
	obj.find(a,start,end);
	for(Point p:obj.minlist){
		System.out.println(p.x+","+p.y);
	}

}
}
