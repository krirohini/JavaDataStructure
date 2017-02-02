package com.javatest.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotPath {
	
	class Point {
		int x; 
		int y;
		boolean isFree;
		Point ( int x, int y ) {
			this.x = x; 
			this.y = y;
		}
		public boolean isFree() {
			return isFree;
		}
		public void setFree(boolean isFree) {
			this.isFree = isFree;
		}
		
		
	}
	
	public boolean getPath( int x, int y, List<Point> pathArray ) {
		Point point = new Point(x,y); 
		
		if( x ==0 && y == 0) {
			return true;
		}
		
		boolean success = false;
		if( x > 0 ) {
			success = getPath(x-1, y, pathArray) ;
		}
		
		if( !success && y > 0) {
			success = getPath(x, y-1, pathArray); 
		}
		
		if( success) {
			pathArray.add(point);
		}
		return success;
	}
	
	public boolean getPathDP( int x, int y, 
			List<Point> pathArray,
			Map<Point, Boolean> visited) {
		
		
		Point point = new Point(x,y); 
		if(visited.containsKey(point)) {
			return visited.get(point).booleanValue();
		}
		if( x ==0 && y == 0) {
			return true;
		}
		
		boolean success = false;
		if( x > 0 ) {
			success = getPath(x-1, y, pathArray) ;
		}
		
		if( !success && y > 0) {
			success = getPath(x, y-1, pathArray); 
		}
		
		if( success) {
			visited.put(point, Boolean.TRUE);
			pathArray.add(point);
		}
		return success;
	}
	
	
	
	// formula (x+y)! / x! y!  
	public static void main(String[] args) {
		List<Point> pathArray = new ArrayList<>();
		
		RobotPath robotPath = new RobotPath();
		
		int x = 5; 
		int y = 4; 
		robotPath.getPath(x, y, pathArray);
		System.out.printf("With recursion from position x = %d , y = %d, no of path %d \n", x, y, pathArray.size());
		pathArray.clear();
		Map<Point, Boolean> visited = new HashMap<>();
		robotPath.getPathDP(x,y, pathArray, visited);
		System.out.printf("With DP from position x = %d , y = %d, no of path %d \n", x, y, pathArray.size());

		
		
		
	}
}
