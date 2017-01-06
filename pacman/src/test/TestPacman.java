package test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import service.PacmanGameService;
/**
 * Run this class and put file at given location to get output.
 * for the given sample it is 
 * "game ends as there is not points/lives remaining
 * your total points earned is 19610"
 * Test class for this Game.
 * @author Siddhant Kumar
 *
 */
public class TestPacman {
	// path of the file
	private static final String FILE_PATH = "H:/pacman/KataPacman-seq.txt";

	public static void main(String[] args) {
		final int lives = 3;
		final int points = 5000;
		// scanner class to get from input file.
		Scanner sc = null;
		try{
			sc = new Scanner(new File(FILE_PATH));
			while(sc.hasNext()){
				String entityList = sc.nextLine();
				PacmanGameService player = new PacmanGameService();
				// call the business class.
				player.printPathAndLives(entityList,points,lives);
			}
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			if(sc!=null)
				sc.close();
		}
	}
}
