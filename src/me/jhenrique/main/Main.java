package me.jhenrique.main;

import java.util.List;
import me.jhenrique.manager.TweetManager;
import me.jhenrique.model.Tweet;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
//		Tweet t = TweetManager.getTweets(null, "2015-01-01", "2015-01-02", "التعليم الجامعى").get(0);
//		Tweet t = TweetManager.getTweets("jimmyfallon", "2015-01-01", "2015-01-02", null).get(0);
		
		/*
		 * Give output filename
		 */
		String filename = "test.csv"; 
		List<Tweet> tweets = TweetManager.getTweets(null, "2015-09-01", "2015-09-05", "allindiabakchod");		
		createCSV(filename, tweets);
		
		/*
		for(Tweet t : tweets){
			//if(t.getRetweets()!=0){
			System.out.println(t.getUsername()+','+t.getRetweets()+','+t.getText());
			System.out.println();	
		}*/
	}
	
	private static void createCSV(String filename, List<Tweet> tweets){
		final String NEW_LINE_SEPARATOR = "\n";
		final String SEMI_COLON_SEPERATOR = ";";
		FileWriter fileWriter = null;
		try{
			fileWriter = new FileWriter(filename);
			for(Tweet tweet: tweets){
				fileWriter.append(tweet.getUsername());
				fileWriter.append(SEMI_COLON_SEPERATOR);
				fileWriter.append(tweet.getDate().toString());
				fileWriter.append(SEMI_COLON_SEPERATOR);
				fileWriter.append(tweet.getText());
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
		}catch(Exception e){
			System.out.println("Error");
		}
	}
}