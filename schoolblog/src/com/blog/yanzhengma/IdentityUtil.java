package com.blog.yanzhengma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.annotation.WebServlet;

public class IdentityUtil {
	private static final Integer WIDTH=100;
	private static final Integer HEIGHT=35;
	private static final char[] CHARS={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private static Random random=new Random();
	public static String getRandomString(){
		StringBuffer buffer=new StringBuffer();
		for(int i=0;i<6;i++){
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}
	public static Color getRandomColor(){
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
	public static Color getReverseColor(Color color){
		return new Color(255-color.getRed(), 255-color.getGreen(), 255-color.getBlue());
	}
	public static BufferedImage getBufferedImage(String randomIdentity){
		Color color=getRandomColor();
		Color reverseColor=getReverseColor(color);
		BufferedImage image=new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_BGR);
		Graphics2D g2= image.createGraphics();
		g2.setColor(color);
		g2.fillRect(0, 0, WIDTH, HEIGHT);
		g2.setColor(reverseColor);
		System.out.println(randomIdentity);
		g2.drawString(randomIdentity, 18, 20);
		for (int i = 0; i <40; i++) {
			g2.drawRect(random.nextInt(WIDTH), random.nextInt(HEIGHT), 1, 1);
		}
		return image;
	}
	public static void main(String[] args) {
		System.out.println(getRandomString());
	}
}
