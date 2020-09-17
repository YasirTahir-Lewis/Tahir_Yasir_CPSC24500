// Designed to get the area and circumference of a circle with random radius

import java.util.Random;
import java.lang.Math;

public class CircleCalc {
	
// Function to calculate area
	public static double computeArea(int radius) {
		
		double area = (Math.pow(radius, 2)) *  Math.PI;
		return area;
		
	}

// Function to calculate circumference of a circle
	public static double computeCircumference(int radius) {
		
		double circumference = 2 * (Math.PI) * radius;
		return circumference;
	
	}

	public static void main(String[] args) {
	
// Declaring variables 
		int radius; double area; double circumference;
		
		Random rnd = new Random();
		
// Giving radius a random value
		radius = rnd.nextInt();
	
// Using functions to compute area and circumference
		area = computeArea(radius);
		circumference = computeCircumference(radius);

// Printing out values for radius, area and circumference 
		System.out.println("Random radius: " + radius);
		System.out.println("Area of a circle: " + area);
		System.out.println("Circumference of a circle: " + circumference);
		
				

	}

}

