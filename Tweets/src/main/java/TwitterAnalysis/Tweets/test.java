package TwitterAnalysis.Tweets;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import TwitterAnalysis.Tweets.WordCount.IntSumReducer;
import TwitterAnalysis.Tweets.WordCount.TokenizerMapper;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//1st book copy to HDFS
		
		String localSrc1="tweets/tweet1.txt";
		
		String dst1="hdfs://cshadoop1/user/sxa151231/tweets"+"tweet1.txt";
		addHDFS.addFile(localSrc1, dst1);
		
		String localSrc2="tweets/tweet2.txt";
		
		String dst2="hdfs://cshadoop1/user/sxa151231/tweets"+"tweet2.txt";
		addHDFS.addFile(localSrc2, dst2);
		
		String localSrc3="tweets/tweet3.txt";
		
		String dst3="hdfs://cshadoop1/user/sxa151231/tweets"+"tweet3.txt";
		addHDFS.addFile(localSrc3, dst3);
		
		
		
				String localSrc4="tweets/tweet4.txt";
				
				String dst4="hdfs://cshadoop1/user/sxa151231/tweets"+"tweet4.txt";
				addHDFS.addFile(localSrc4, dst4);
		
		
				String localSrc5="tweets/tweet5.txt";
				
				String dst5="hdfs://cshadoop1/user/sxa151231/tweets"+"tweet5.txt";
				addHDFS.addFile(localSrc5, dst5);
				
				String localSrc6="tweets/tweet6.txt";
				
				String dst6="hdfs://cshadoop1/user/sxa151231/tweets"+"tweet6.txt";
				addHDFS.addFile(localSrc6, dst6);
		
				
				
				 Configuration conf = new Configuration();
				    conf.set("mapred.job.tracker", "hdfs://cshadoop1:61120");
				    conf.set("yarn.resourcemanager.address", "cshadoop1.utdallas.edu:8032");
				    conf.set("mapreduce.framework.name", "yarn");
				    Job job = Job.getInstance(conf, "word count");
				    job.setJarByClass(WordCount.class);
				    job.setMapperClass(TokenizerMapper.class);
				    job.setCombinerClass(IntSumReducer.class);
				    job.setReducerClass(IntSumReducer.class);
				    job.setOutputKeyClass(Text.class);
				    job.setOutputValueClass(IntWritable.class);
				    FileInputFormat.addInputPath(job, new Path(args[0]));
				    FileOutputFormat.setOutputPath(job, new Path(args[1]));
				    System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}