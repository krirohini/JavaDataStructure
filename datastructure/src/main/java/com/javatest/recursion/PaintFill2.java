package com.javatest.recursion;

import java.util.Arrays;

/**
 * 8.6 Implement the “paint fill” function that one might see on many image
 * editing programs. That is, given a screen (represented by a 2-dimensional
 * array of Colors), a point, and a new color, fill in the surrounding area
 * until you hit a border of that color.
 *
 */
public class PaintFill2 {
	enum Color { Black, White,  Red, Yellow, Green };

	public static Color[][]  constructScreen () {
		Color[][] screen = new Color [] []  {
			{Color.Green,Color.Black,Color.Black,Color.Black},
			{Color.Black,Color.Red,Color.Red,Color.Black},
			{Color.Black,Color.Red,Color.Red,Color.Black},
			{Color.Black,Color.Red,Color.Red,Color.Black},
			{Color.Black,Color.Black,Color.Black,Color.Black}
		}; 
		return screen;
	}

	private static void printScreen(Color[][] screen) {
		for(int i = 0 ; i <screen.length ; i++ ) { 
			System.out.println(Arrays.toString(screen[i]));
		}

	}
	


	public static void main(String[] args) {
		Color[][]  screen = constructScreen();
		System.out.println(screen.length);
		System.out.println(screen[0].length);
		System.out.println("Before Transformation");
		printScreen(screen);
		//out of boundry 
		paintFill(screen, 2,1, Color.Green);
		//same color 
		//paintFill(screen, 0,0, Color.Green);
		//inner fill
		//paintFill(screen, 1,2, Color.Green);
		//outer fill
		//paintFill(screen, 0,1, Color.Green);
		
		System.out.println("After Transformation");
		printScreen(screen);
		
	}

	
	public static boolean paintFill(Color [] [] scr , int x , int y , Color nColor) {
		if(x < 0 || x >= scr[0].length || y < 0 || y >= scr.length) {
			return false; 
		}
		return paintFill(scr, x, y , scr[y][x] , nColor); 
		
	}

	public static boolean paintFill(Color [] [] scr , int x , int y , Color oColor, Color nColor) {
		
		if(x < 0 || x >= scr[0].length || y < 0 || y >= scr.length) {
			return false; 
		}
		
		if(scr[y][x] == oColor) {
			scr[y][x] = nColor; 
			 paintFill(scr, x-1, y , oColor , nColor);
			 paintFill(scr, x+1, y , oColor , nColor);
			 paintFill(scr, x, y-1, oColor , nColor);
			 paintFill(scr, x, y+1 , oColor , nColor);
		}
		return true; 
		
	}







	
		}
}
