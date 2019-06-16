package com.common.until;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class newsGet {
	
	public static List readFile() throws IOException {
		List list = new ArrayList<String>();
        String pathname = "E://pythonPj/newsInfo/saveText/newsInfo.txt";
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(pathname), "UTF-8");
             BufferedReader br = new BufferedReader(reader) 
        ) {
            String line;
            String a[];
            while ((line = br.readLine()) != null) {
                //line = new String(line.getBytes("GBK"),"UTF-8");
            	a = line.split(" ");
                list.add(a[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public static void main(String[] args) throws IOException {
		List li = new ArrayList<String>();
		li=readFile();
		Iterator<String> iter = li.iterator();
		while(iter.hasNext()){  
		    System.out.println(iter.next());
		}
	}
}	
