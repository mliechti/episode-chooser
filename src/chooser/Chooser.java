package chooser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
			for (CSVRecord csvRecord : parser) {
				if (csvRecord.size() > 5) {
					System.out.println(csvRecord.get(SEASON) + " - " + csvRecord.get(EPISODE) + " - " + csvRecord.get(NAME));
				}
			}
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