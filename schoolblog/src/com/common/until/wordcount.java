package com.common.until;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 
 * 统计词频
 * 
 * @author Administrator
 *
 */
public class wordcount {

	static Map<String, Integer> wordMap = new HashMap<String,Integer>();
	//传一个目录路径
	public static List readFile(String path) throws IOException {
		File dir = new File(path);
		File[] files = dir.listFiles();
		List list = new ArrayList();
		for (File file : files) {
            if (!file.isDirectory()) {// 如果遍历到当前的file对象是个目录，继续遍历。
            	list.add(file.getName());
            } 
        }
		for(int i=0;i<list.size();i++){
			String pathname = path+"/"+list.get(i);
	        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(pathname), "GBK");
	             BufferedReader br = new BufferedReader(reader) 
	        ) {
	            String line;
	            String a[];
	            while ((line = br.readLine()) != null) {
	                //line = new String(line.getBytes("GBK"),"UTF-8");
	            	a = line.split(" ");
	            	//存在hashmap中的词频+1
	            	if(wordMap.get(a[2])!=null){
	            		wordMap.put(a[2],wordMap.get(a[2])+1);
	            	}else{
	            		wordMap.put(a[2], 1);
	            	}
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
		//对词频进行排序
		List<Map.Entry<String, Integer>> l = new ArrayList<Map.Entry<String, Integer>>(wordMap.entrySet());
	    Collections.sort(l, new Comparator<Map.Entry<String, Integer>>() {//根据value排
	    	@Override
			public int compare(Map.Entry<String, Integer> o1,
				Map.Entry<String, Integer> o2) {
			    double result = o2.getValue() - o1.getValue();
			    if(result > 0)
			    	return 1;
			    else if(result == 0)
			    	return 0;
			    else 
			    	return -1;
	    	}
	    });
        return l;
    }
	
	public static void main(String[] args) throws IOException {
		wordcount w = new wordcount();
		List m = w.readFile("E:/logs/admin");
		System.out.println(m.toString());
		List l2 = new ArrayList();
		for(int i=0;i<m.size();i++){
			String str[] = m.get(i).toString().split("=");
			if(str[0].equals("推荐") || str[0].equals("最新文章")){
				continue;
			}else{
				l2.add(str[0]);
			}
		}
		System.out.println(l2.toString());
	}
}
