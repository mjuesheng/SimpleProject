package com.hadoop.wordcount;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * 打成jar包，传到Linux  (打成jar包时，引入的jar包可能不会封装到里面)
 * hadoop jar worcount.jar cn.itcast.bigdata.mr.wcDemo.WordcountDriver /wordcount/input /wordcount/output
 * 
 * @author Administrator
 *
 */
public class WordcountDriver {
	
	public WordcountDriver(String username) throws Exception{
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式 
		String date = df.format(new Date());
		Configuration conf =new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(WordcountDriver.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		String InputPath = "E:/logs/"+username;
		String OutputPath ="E:/logs/mr-analysis-"+date;
		
		FileInputFormat.setInputPaths(job, new Path(InputPath));
		FileOutputFormat.setOutputPath(job, new Path(OutputPath));

		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordcountReducer.class);
		
		boolean res = job.waitForCompletion(true);
		System.exit(res?0:1);
	}
	
	
	public static void main(String[] args) {
		try {
			WordcountDriver w = new WordcountDriver("admin");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
