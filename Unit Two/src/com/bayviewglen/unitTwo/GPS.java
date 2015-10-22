package com.bayviewglen.unitTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GPS {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("input/GPSdata.dat"));
		int x = Integer.parseInt(input.nextLine());
		double[][] points = new double[x][2];
		
		for (int i = 0; i < points.length; i++) {
			points[i][0] = Double.parseDouble(input.nextLine());
			points[i][1] = Double.parseDouble(input.nextLine());
		}
		
		checkClosestPoint(points);

	}

	private static void checkClosestPoint(double[][] points) {
		double shortestDistance = 100000;
		int point1 = -1;
		int point2 = -1;
		
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length - i - 1; j++ ) {
				double x = points[i][0] - points[j][0];
				double y = points[i][1] - points[j][1];
				double distance = Math.sqrt(x * x + y * y);
				if (distance < shortestDistance) {
					shortestDistance = distance;
					point1 = i;
					point2 = j;
				}
			}
		}
		
		System.out.println("The closest two points are (" + points[point1][0] + ", " + points[point1][1] + ") and (" + points[point2][0] + ", " + points[point2][1] + ")");
		
	}
	
}
