package com.common.until;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hadoop.wordcount.WordcountDriver;

public class Logger {
	String username;
	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
	String dateFile = df.format(new Date());
	
	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");//设置日期格式 
	String date = df2.format(new Date());
	
	public Logger(String username){
		this.username = username;
	}
	
	public void log(String message){
		String path = "E://logs";
		File f = new File(path);
		if(!f.exists()){
			f.mkdir();
		}
		path = "E://logs//"+username;
		f = new File(path);
		
		if(!f.exists()){
			f.mkdir();
		}
		
		path = "E://logs//"+username+"//"+dateFile+".txt";
		f = new File(path);
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileWriter writer;
		try {
			writer = new FileWriter(path, true);
			writer.write(date+message+"\r\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void error(String error){
		String path = "E://logs//"+username;
		File f = new File(path);
		
		if(!f.exists()){
			f.mkdir();
		}
		
		path = "E://logs//error//"+dateFile+".txt";
		f = new File(path);
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileWriter writer;
		try {
			writer = new FileWriter(path, true);
			writer.write(date+error+"\r\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}