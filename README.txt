Due to the huge amount of twitter data being downloaded I had to divide the functionality of downloading
in a separate JAVA program.
There are 2 JAVA programs.
1.JAVA Twitter Application has the JAVA file to download tweets locally to your system.
Please note I have used the twitter4j API to download the tweets so to build this JAVA file you will need to download latest 
version of twitter4j API from Twitter.
2. I have created a folder for tweets named-Tweets and all the tweet files are stored there.
3.Now import the JAR file for Tweets project into the working directory and run the following command.
 hadoop jar Tweets-0.0.1-SNAPSHOT.jar  TwitterAnalysis.Tweets.test hadoop/folder/sourcefile   hadoop/folder/destinationfile

This will read the tweet files uploaded from the local server folder tweets to hdfs://folder/sourcefile tweets 
it will then search for each hashtag in the file and then return the highest trend for each hashtag.
This will be written in the file in the following directory: hdfs://folder/destination

Now we will read the file generated under this folder tweetanalysis and run the below command to find the map-reduce result:
HDFS DFS -CAT /SOURCEFILE/TWEETANALYSIS/F1/PART-00000


This Twitter Analysis was based on the following idea and covered the following aspects:
1. The US elections are today the most talked about topic on twitter.So I had analyzed the potential candidates 
like Hillary Clintion and Bernie Sanders.
2.I had searched for a duration of last 6 days using Twitter search API instead of Twitter Stream API.
3.The files I had generated are over 200MB each and so I had to split them so that I can move them to the server and use the
map-reduce functionality over them.I have analyzed over 15MB of twitter data using this.

The sample results from the file are noted as below:
HillaryClinton 111345
BernieSanders 12222
