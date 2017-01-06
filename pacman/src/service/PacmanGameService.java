package service;

import dto.Pacman;
import score.CalculatePoint;
import score.Point;
/**
 * Main business class to play and print paths and lives
 * during play.
 * @author Siddhant Kumar
 *
 */
public class PacmanGameService {
	// constant for entity Invincible Ghost.
	private static final String INVINCIBLE_GHOST = "InvincibleGhost";
	// constant for entity Vulnerable Ghost
	private static final String VULNERABLE_GHOST = "VulnerableGhost";
	// points for each life gained by player.
	private static int LIFESCORE=10000;
	// count variable for the Vulnerable ghost 
	// which will increase for each time it gets Vulnerable entity.
	private int countVulnerableGhost=0;
	public void printPathAndLives(String enitityList,int points,int lives){
		Pacman pacman = new Pacman(points,lives);
		String[] entities = enitityList.split(",");
		Point obj = new CalculatePoint();
		for(int i=0;i<entities.length;i++){
			int totalPoints = pacman.getPoints();
			int totalLives = pacman.getLives();
			// if entity is vulnerable ghost
			if(entities[i].equals(VULNERABLE_GHOST)){
				if(countVulnerableGhost<4) countVulnerableGhost++;
				totalPoints+=obj.getPoints(countVulnerableGhost,entities[i]);
			}
			// if entity is Invincible ghost
			else if(entities[i].equals(INVINCIBLE_GHOST)){
				totalLives--;
			}
			// for all other entities eaten by pac-man
			else {
				totalPoints+=obj.getPoints(entities[i]);
			}
				
			if(totalPoints>=LIFESCORE){
				LIFESCORE+=10000;
				totalLives++;
			}
			if(totalLives<=0){
				System.out.println("game ends as there is not points/lives remaining");
				System.out.println("your total points earned is "+totalPoints);
				return;
			}
			pacman.setPoints(totalPoints);
			pacman.setLives(totalLives);
		}
		System.out.println("Total lives and points at this time is "+pacman.getLives()+" "+pacman.getPoints());
	}
}
