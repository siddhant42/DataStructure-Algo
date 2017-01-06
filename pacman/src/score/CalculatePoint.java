package score;

import constants.ConstPoints;
/**
 * implementation of the Point interface to
 * get points earned by player during play.
 * @author Siddhant Kumar
 *
 */
public class CalculatePoint implements Point {
// points earned by player by eating Vulnerable Ghost
	@Override
	public int getPoints(int count,String name) {
		return (int)Math.pow(2, count-1)*ConstPoints.getInstance().getPoint(name);
	}
	// points earned by player by eating other entities
	@Override
	public int getPoints(String name) {
		return ConstPoints.getInstance().getPoint(name);
	}

}
