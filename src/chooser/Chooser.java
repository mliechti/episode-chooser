package chooser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Chooser {
	private final static int SEASON = 1;
	private final static int EPISODE = 2;
	private final static int NAME = 5;
	
	public static void main(String[] args) {
		System.out.println("hello world");
		Chooser chooser = new Chooser();
		String tvSeries = chooser.getSeriesFromUser();
		chooser.getRandomEpisode(tvSeries);
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
	//Lookup the full list of episodes from internet and randomly choose one
	public String getRandomEpisode(String tvSeries) {
		// get list from internet
		URL csvURL;
		try {
			csvURL = new URL("http://epguides.com/common/exportToCSV.asp?rage=18411");
			CSVParser parser = CSVParser.parse(csvURL, StandardCharsets.UTF_8, CSVFormat.DEFAULT);
			ArrayList<String> episodeList = new ArrayList<String>();
			for (CSVRecord csvRecord : parser) {
				if (csvRecord.size() > 5) {
					String epString = csvRecord.get(SEASON) + " - " + csvRecord.get(EPISODE) + " - " + csvRecord.get(NAME);
					System.out.println(epString);
					episodeList.add(epString);
				}
			}
			System.out.println("ep list size: " + episodeList.size());
			System.out.println("ep list data: " + episodeList.toString());
			Random randomGen = new Random();
			int randomInt = randomGen.nextInt(episodeList.size());
			System.out.println("random #: " + randomInt);
			System.out.println("Your random episode: " + episodeList.get(randomInt));
			

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failure on csv parsing of url");
		} 


		return "";
	}

	
	//Start playing the episode (should be another module)
}