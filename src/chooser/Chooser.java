package chooser;

import java.util.Scanner;

public class Chooser {
	
	public static void main(String[] args) {
		System.out.println("hello world");
		Chooser chooser = new Chooser();
		chooser.getSeriesFromUser();
	}
	
	//Get TV series to look up from user
	public String getSeriesFromUser() {
		Scanner keyboard = new Scanner(System.in);
		try {
		
			System.out.println("What TV series do you want to watch?");
			
			String tvSeries = keyboard.nextLine();
			System.out.println("You chose " + tvSeries);
			return tvSeries;
		}
		finally {
			keyboard.close();
		}
		
	}
	//Lookup the full list of episodes from internet
	
	//Randomly choose one of the episodes
	
	//Start playing the episode (should be another module)
}