package com.changhun.leetcode.for101to200;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6


LinkedIn

 * @author changhun
 *
 */
public class L149_MaxPointsOnLine {
	public static class Point {
		int x;
		int y;
		Point() { 
			x = 0; 
			y = 0; 
		}
		Point(int a, int b) { 
			x = a; 
			y = b;
		}
		
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
	
	
	/**
	 * for each point, compute slope and put slope to the map and count number of points with same slope
	 * @param points
	 * @return
	 */
	public static int maxPoints(Point[] points) {
		if (points == null || points.length == 0) return 0;
		int result = 0;
		 
		Map<String, Integer> map = new HashMap<>();
		// double for loop to try all points. O(n^2)
		for (int i = 0; i < points.length; i++) {
			int max = 0, overlap = 0;
			map.clear();
			for (int j = i + 1; j < points.length; j++) {
				
				System.out.println(points[i].toString() + " " + points[j].toString());
				
				int x = points[j].x - points[i].x;
				int y = points[j].y - points[i].y;
				if (x == 0 && y == 0) {
					overlap++;
					continue;
				}
				int gcd = findGCD(x, y);
				if (gcd != 0) {
					x /= gcd;
					y /= gcd;
				}
				String key = x + "@" + y;//slope
				if (map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
				
				max = Math.max(max, map.get(key));
			}
			System.out.println(map.toString());

			result = Math.max(result, max + overlap + 1);	//1 for point i
			System.out.println(max + " " + overlap + " " + result);

		}
		return result;
	}

	private static int findGCD(int a, int b) {
		if (b == 0) return a;
		return findGCD(b, a % b);
	}
	 
	public static void main(String[] args) {
		Point [] points = {new Point(1,1), new Point(2,2), new Point(3,3)};		
		System.out.println("results = " + maxPoints(points));
	
		Point [] points2 = {new Point(1,1), new Point(3,2), new Point(5,3), new Point(4,1), new Point(2,3), new Point(1,4)};		
		System.out.println("results = " + maxPoints(points2));
		
	}
}
