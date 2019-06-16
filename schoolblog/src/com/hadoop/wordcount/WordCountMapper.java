package com.hadoop.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



/**
 * -----����ͳ��------
 * 
 * KEYIN :  Ĭ������£���mr�����������һ���ı�����ʼƫ���� Long
 * VALUEIN:Ĭ������£���mr�����������һ���ı������ݣ�String
 * 
 * KEYOUT:���û��Զ����߼��������֮����������е�key���ڴ˴��ǵ��ʣ�String
 * VALUEOUT�����û��Զ����߼��������֮����������е�value���ڴ˴��ǵ��ʴ�����Integer
 * 
 * @author Administrator
 *
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	/**
	 * map�׶ε�ҵ���߼���д���Զ����map����������
	 * maptask���ÿһ���������ݵ���һ�������Զ����map��������
	 * 
	 */
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		//��maptask�������ǵ��ı�������ת����string
		String line=new String(value.getBytes(),0,value.getLength(),"GBK");
		//���ݿո���һ���зֳɵ���
		String[] words = line.split(" ");
		
		String word = words[2];
		context.write(new Text(word), new IntWritable(1));
		
	}
}
