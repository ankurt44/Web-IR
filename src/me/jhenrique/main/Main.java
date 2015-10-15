package me.jhenrique.main;

import java.util.List;
import me.jhenrique.manager.TweetManager;
import me.jhenrique.model.Tweet;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	private static String PATH = "/Users/ank/Documents/Q1WebIR/twitterData";
	public static void main(String[] args) {
//		Tweet t = TweetManager.getTweets(null, "2015-01-01", "2015-01-02", "التعليم الجامعى").get(0);
//		Tweet t = TweetManager.getTweets("jimmyfallon", "2015-01-01", "2015-01-02", null).get(0);
		
		/*
		 * Give output filename
		 */
		String filename = PATH + "TweetsObama.csv"; 
		System.out.println("Getting tweets.. Wait..");
		List<Tweet> tweets = TweetManager.getTweets(null, "2015-09-01", "2015-09-02", "BarackObama");
		System.out.println("Tweets retrieved!!");
		System.out.println("Writing them to CSV file.");
		createCSV(filename, tweets);
		System.out.println("Tweets written to CSV file at lovation:"+PATH+" and filename is:"+filename);
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
			fileWriter.append("UserName");
			fileWriter.append(SEMI_COLON_SEPERATOR);
			fileWriter.append("Date");
			fileWriter.append(SEMI_COLON_SEPERATOR);
			fileWriter.append("Favorites");
			fileWriter.append(SEMI_COLON_SEPERATOR);
			fileWriter.append("Retweets");
			fileWriter.append(SEMI_COLON_SEPERATOR);
			fileWriter.append("Text");
			fileWriter.append(NEW_LINE_SEPARATOR);
			for(Tweet tweet: tweets){
				fileWriter.append(tweet.getUsername());
				fileWriter.append(SEMI_COLON_SEPERATOR);
				fileWriter.append(tweet.getDate().toString());
				fileWriter.append(SEMI_COLON_SEPERATOR);
				fileWriter.append(Integer.toString(tweet.getFavorites()));
				fileWriter.append(SEMI_COLON_SEPERATOR);
				fileWriter.append(Integer.toString(tweet.getRetweets()));
				fileWriter.append(SEMI_COLON_SEPERATOR);
				fileWriter.append(tweet.getText());
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
		}catch(Exception e){
			System.out.println("Error");
		}
	}
}