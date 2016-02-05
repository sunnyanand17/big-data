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
public class FirstTwitter {

	public static void main(String[] args) throws TwitterException,IOException{
		// TODO Auto-generated method stub

		ConfigurationBuilder cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true);
		cf.setOAuthConsumerKey("XQ6zBE75tWFLu5wNfAzVk23H6");
		cf.setOAuthConsumerSecret("CIhijuih3p7IckjqUEJAXAc03v8rr9hLd4ptX7QFocy0acOlaU");
		cf.setOAuthAccessToken("4851601868-DrzBqJZlYhUUZ62cf9Uo9sq1ujWNVyL6RDM3vAd");
		cf.setOAuthAccessTokenSecret("KY1FIDJhGGBJ7Lh12yMGuC0CGqe4tInnceb1i48wy5mLS");
		TwitterFactory tf = new TwitterFactory(cf.build());
		//if (args.length < 1) {
          //  System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            //System.exit(-1);
        //}
		twitter4j.Twitter twitter = tf.getInstance();
		//To get all the hometimeline tweets.
		
		//ResponseList <Status> status = twitter.getHomeTimeline();
		//for(Status st:status)
		//{
			//System.out.println(st.getUser().getName()+"------"+st.getText());
		//}
		try {
            Query query = new Query("elections");
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                /*
                File fout = new File("out.txt");
            	FileOutputStream fos = new FileOutputStream(fout);
             
            	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
             
            	 for (Status tweet : tweets) {
            		bw.write("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
            		bw.newLine();
            	}
             
            	bw.close();
                */
                /*FileWriter writer = new FileWriter("output.txt"); 
                for (Status tweet : tweets) {
                  writer.write("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
                writer.close();
                */
                
                String str1 ="";
                List<String> terms = new ArrayList<String>();
                long count=0;
                for (Status tweet : tweets) {
                	str1 = "@" + tweet.getUser().getScreenName() + " - " + tweet.getText();
                    terms.add(str1);
                    count = count +1;
                    System.out.println(count);
                }
                System.out.println(count);
                FileWriter writer = new FileWriter("outputfile0001.txt",true); 
                for(String str:terms) {
                  writer.write(str);
                }
                writer.close();
              
                
                	
                for (Status tweet : tweets) {
                   System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }/*catch (IOException ie) {
            ie.printStackTrace();
            System.out.println("Failed to search tweets: " + ie.getMessage());
            System.exit(-1);
        }*/
	}

}
