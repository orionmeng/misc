///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Number Guess Game
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
import java.util.Random;

public class NumberGuess{
	
	public static void main(String[] args){
		
		Random randGen = new Random(Config.SEED);
		int randAnswer = randGen.nextInt(100) + 1;
		
		Scanner scnr = new Scanner(System.in);
		System.out.print("Please make a guess between 1 and 100: ");
		int userGuess;
		userGuess = scnr.nextInt();
		
		if (userGuess == randAnswer) {
			System.out.print("You won in 1 trials!");
		}
		else {
			
			int guessMin = 1;
			int guessMax = 100;
			int sumTrials = 1;
			
			for (int i = userGuess; i != randAnswer; i = scnr.nextInt()) {
				
				if (i < guessMin || i > guessMax) {
					System.out.print("Please make a guess between " + guessMin + " and " + guessMax + ": ");
					sumTrials += 1;
					continue;
				}
				else if (i < randAnswer) {
					guessMin = i;
					System.out.print("Please make a guess between " + guessMin + " and " + guessMax + ": ");
					sumTrials += 1;
					continue;
				}
				else if (i > randAnswer) {
					guessMax = i;
					System.out.print("Please make a guess between " + guessMin + " and " + guessMax + ": ");
					sumTrials += 1;
					continue;
				}
				
			}
			
			System.out.print("You won in " + sumTrials + " trials!");
			
		}
		
	}
	
}
