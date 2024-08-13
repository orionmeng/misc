///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Minimum Maximum Average
// Course:          CS 200, Term 1, Year 2020
//
// Author:          Orion Meng
// Email:           dmeng8@wisc.edu
// Lecturer's Name: Mr. Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// N/A
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.Scanner;

class MinMaxAvg {
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		int[] tenValues = new int[10];
		int minVal = 0;
		int maxVal = 0;
		double avgVal = 0.0;
		
		System.out.print("");
		
		for (int i = 0; i < tenValues.length; ++i) {
			tenValues[i] = scnr.nextInt();
		}
		
		minVal = tenValues[0];
		maxVal = tenValues[0];
		double numVal = 0.0;
		double sumVal = 0.0;
		
		for (int j = 0; j < tenValues.length; ++j) {
			if (minVal > tenValues[j]) {
				minVal = tenValues[j];
			}
			if (maxVal < tenValues[j]) {
				maxVal = tenValues[j];
			}
			numVal += 1;
			sumVal += tenValues[j];
		}
		
		avgVal = (sumVal / numVal);
		System.out.println(minVal + " " + maxVal + " " + avgVal);
		
	}
	
}
