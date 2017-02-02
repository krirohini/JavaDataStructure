package com.javatest.recursion;

import java.util.Arrays;

public class PaintFill {
	enum Color { Black, White,  Red, Yellow, Green 	

	};

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
	
	private static boolean isIndexInsideScreen ( Color [] [] screen, int x, int y) {
		// check boundry condition 
				if (x < 0 || x >= screen[0].length ||
						y < 0 || y >= screen.length) {
					return false;
				}
				return true;
	}


	private static boolean paintFill(Color[][] screen, int x, int y,
			Color ocolor, Color ncolor) {

		// check boundry condition 
		if (isIndexInsideScreen(screen, x,y) == false ) {
			return false;
		} 

		if (screen[y][x] == ocolor) {
			screen[y][x] = ncolor;
			paintFill(screen, x - 1, y, ocolor, ncolor); // left 
			paintFill(screen, x + 1, y, ocolor, ncolor); //right 
			paintFill(screen, x, y - 1, ocolor, ncolor); //top 
			paintFill(screen, x, y + 1, ocolor, ncolor); // bottom 
		}
		return true;
	}
	// ordering of the x and y in screen[y] [x], and remember this when you hit
	// graphical problem. Because x represents the horizontal axis {that is, it's left to right

	private static boolean paintFill(Color[][] screen, int x, int y , Color nColor) {
		// check boundry condition 
		if (isIndexInsideScreen(screen, x,y) == false ) {
			return false;
		}

		if (screen[y][x] == nColor) {
			return false;
		}
		return paintFill(screen, x, y, screen[y][x], nColor) ;

	}

	public static void main(String[] args) {
		Color[][]  screen = constructScreen();
		System.out.println(screen.length);
		System.out.println(screen[0].length);
		System.out.println("Before Transformation");
		printScreen(screen);
		//out of boundry 
		paintFill(screen, 6,6, Color.Green);
		//same color 
		//paintFill(screen, 0,0, Color.Green);
		//inner fill
		//paintFill(screen, 1,2, Color.Green);
		//outer fill
		//paintFill(screen, 0,1, Color.Green);
		
		System.out.println("After Transformation");
		printScreen(screen);
		
	}




}
