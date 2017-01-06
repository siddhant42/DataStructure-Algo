package dto;
/**
 * Pojo class to get and set points and lives of the player.
 * @author Siddhant Kumar
 *
 */
public class Pacman {
	// points of the player
	private int points;
	// lives of the player
	private int lives;
	// default constructor
	public Pacman() {
		super();
	}
	// argument constructor
	public Pacman(int points, int lives) {
		super();
		this.points = points;
		this.lives = lives;
	}
	// gettes and setters for the points and lives of player.
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}

}
