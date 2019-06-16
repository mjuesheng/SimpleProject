package com.hadoop.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



/**
 * -----单词统计------
 * 
 * KEYIN :  默认情况下，是mr框架所读到的一行文本的起始偏移量 Long
 * VALUEIN:默认情况下，是mr框架所读到的一行文本的内容，String
 * 
 * KEYOUT:是用户自定义逻辑处理完成之后输出数据中的key，在此处是单词，String
 * VALUEOUT：是用户自定义逻辑处理完成之后输出数据中的value，在此处是单词次数，Integer
 * 
 * @author Administrator
 *
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	/**
	 * map阶段的业务逻辑就写在自定义的map（）方法中
	 * maptask会对每一行输入数据调用一次我们自定义的map（）方法
	 * 
	 */
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		//将maptask传给我们的文本内容先转换成string
		String line=new String(value.getBytes(),0,value.getLength(),"GBK");
		//根据空格将这一行切分成单词
		String[] words = line.split(" ");
		
		String word = words[2];
		context.write(new Text(word), new IntWritable(1));
		
	}
}
