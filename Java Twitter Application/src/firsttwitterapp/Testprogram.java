package firsttwitterapp;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

import twitter4j.*;
//import twitter4j.api.TrendsResources;
import twitter4j.conf.ConfigurationBuilder;

public class Testprogram {
	public static void main(String[] args) throws TwitterException,IOException{
		// TODO Auto-generated method stub

		ConfigurationBuilder cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true);
		cf.setOAuthConsumerKey("XQ6zBE75tWFLu5wNfAzVk23H6");
		cf.setOAuthConsumerSecret("CIhijuih3p7IckjqUEJAXAc03v8rr9hLd4ptX7QFocy0acOlaU");
		cf.setOAuthAccessToken("4851601868-DrzBqJZlYhUUZ62cf9Uo9sq1ujWNVyL6RDM3vAd");
		cf.setOAuthAccessTokenSecret("KY1FIDJhGGBJ7Lh12yMGuC0CGqe4tInnceb1i48wy5mLS");
		TwitterFactory tf = new TwitterFactory(cf.build());
		twitter4j.Twitter twitter = tf.getInstance();
		
		//Twitter twitter = new TwitterFactory().getInstance();
        try {
        	
        	String str1 ="";
            List<String> terms = new ArrayList<String>();
            FileWriter writer = new FileWriter("outputfile000115.txt",true); 
        	for(int i=0;i<5;i++){
            Query query = new Query("bernie sanders");
            query.count(1000);
            query.until("2016-02-01");
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                	str1 = "@" + tweet.getUser().getScreenName() + " - " + tweet.getText();
                    terms.add(str1); }
                for(String str:terms) {
                    writer.write(str);
                  }
            } while ((query = result.nextQuery()) != null);
            Thread.sleep(30000);
        	}
        	  writer.close();
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
    }
		
	}	
		
		
}
