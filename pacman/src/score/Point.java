package score;
/**
 * Interface Point which provides functionality for
 * get points earned by player.
 * @author Siddhant Kumar
 *
 */
public  interface Point {
	// get points for vulnerable ghost
	public abstract int getPoints(int count,String name);
	// get point for entities eaten by pac-man
	public abstract int getPoints(String name);
}
