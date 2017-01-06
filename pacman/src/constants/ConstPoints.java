package constants;

import java.util.HashMap;
import java.util.Map;
/**
 * Singleton class used for constants to set and get points
 * earned by player.
 * @author Siddhant Kumar
 *
 */
public final class ConstPoints {
	private static final Map<String,Integer> pointList = new HashMap<>();

	private ConstPoints(){
		pointList.put("Cherry", 100);
		pointList.put("Strawberry", 300);
		pointList.put("Orange", 500);
		pointList.put("Apple", 700);
		pointList.put("Melon", 1000);
		pointList.put("Galaxian", 2000);
		pointList.put("Bell", 3000);
		pointList.put("Key", 5000);
		pointList.put("Life", 10000);
		pointList.put("Dot", 10);
		pointList.put("VulnerableGhost", 200);
	}
	static class Singleton{
		private static final ConstPoints INSTANCE = new ConstPoints();
	}
	public static ConstPoints getInstance(){
		return Singleton.INSTANCE;
	}
	public Integer getPoint(String name){
		if(pointList.containsKey(name))
			return pointList.get(name);
		else
			return 0;
	}
}
