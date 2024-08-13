///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Array List Lab
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
import java.util.ArrayList;
import java.lang.Math;

public class ArrayListFun {
   
   /**
	 * Counts the number of instances of a particular value in list.
	 * Returns null if list is null.
	 * 
	 * @param list
	 * @param checkNum
	 * @return the number of Integer occurrences in list equal to checkNum
	 */
	public static Integer countOccurrences(ArrayList<Integer> list, int checkNum) {
		
		if (list != null) {
			if (list.isEmpty()) {
				return 0;
			}
			else {
				int sumReturn = 0;
				for (int i = 0; i < list.size(); ++i) {
					if (list.get(i) == checkNum) {
						sumReturn += 1;
					}
					else {
						continue;
					}
				}
				Integer returnVal;
				returnVal = 0;
				returnVal = sumReturn;
				return returnVal;
			}
		}
		else {
			return null;
		}
		
	}
	
	/**
	 * Calculates the sum, product, or mean of all values in list.
	 * Returns null if list is null.
	 * 
	 * @param list
	 * @param operation
	 * @return the sum, product, or mean of all values in list
	 */
	public static Integer mathOperation(ArrayList<Integer> list, String operation) {
		
		if (list != null) {
			if (list.isEmpty()) {
				return 0;
			}
			else {
				int answerReturn = 0;
				if (operation.equals("add")) {
					answerReturn = 0;
					for (int i = 0; i < list.size(); ++i ) {
						answerReturn += list.get(i);
					}
					return answerReturn;
				}
				else if (operation.equals("multiply")) {
					answerReturn = 1;
					for (int i = 0; i < list.size(); ++i ) {
						answerReturn *= list.get(i);
					}
					return answerReturn;
				}
				else if (operation.equals("mean")) {
					int sumVal = 0;
					answerReturn = 1;
					for (int i = 0; i < list.size(); ++i ) {
						answerReturn += list.get(i);
						sumVal += 1;
					}
					answerReturn = answerReturn / sumVal;
					return answerReturn;
				}
				else {
					Integer returnVal;
					returnVal = 0;
					returnVal = answerReturn;
					return returnVal;
				}
			}
		}
		else {
			return null;
		}
		
	}
	
	/**
	 * Converts the 1s and 0s in list (binary value) to its decimal value
	 * 
	 * Example: 100110 from binary to decimal
	 * 
	 * 1 * 2^5 +
	 * 0 * 2^4 +
	 * 0 * 2^3 +
	 * 1 * 2^2 +
	 * 1 * 2^1 +
	 * 0 * 2^0 =
	 * 38
	 * 
	 * For more information on binary, see zyBooks chapter 3.1
	 * 
	 * Returns null if list is null.
	 * 
	 * @param list
	 * @return the decimal value of the binary representation of list
	 */
	public static Integer binaryToDecimal(ArrayList<Integer> list) {
		
		if (list != null) {
			if (list.isEmpty()) {
				return 0;
			}
			else {
				int answerReturn = 0;
				int j = 1;
				for (int i = list.size() - 1; i > -1; --i) {
					answerReturn += (list.get(i) * j);
					j *= 2;
				}
				Integer returnVal;
				returnVal = 0;
				returnVal = answerReturn;
				return returnVal;
			}
		}
		else {
			return null;
		}
		
	}
	
	/**
	 * Returns true if list is a (character) palindrome.
	 * Returns null if list is null.
	 * 
	 * @param list
	 * @return true if the list is a palindrome, else false. 
	 */
	public static Boolean isPalindrome(ArrayList<Character> list) {
		
		if (list != null) {
			if (list.isEmpty()) {
				return true;
			}
			else {
				int wholeListSize = 0;
				wholeListSize = list.size();
				int halfListSize = 0;
				halfListSize = wholeListSize / 2;
				boolean isPali = true;
				if (wholeListSize == 0 || wholeListSize == 1) {
					isPali = true;
				}
				else {
					for (int i = 0; i < halfListSize; ++i) {
						if (list.get(i).equals(list.get(wholeListSize - 1 - i))) {
							isPali = true;
							continue;
						}
						else {
							isPali = false;
							break;
						}
					}
				}
				return isPali;
			}
		}
		else {
			return null;
		}
		
	}
	
	/**
	 * The main method.
	 * 
	 */
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		/*
		//first count array
		System.out.println("");
		ArrayList<Integer> countOne = new ArrayList<Integer>();
		do {
			countOne.add(scnr.nextInt());
		} while (scnr.hasNext());
		//first count check
		System.out.println("");
		int numOne = 0;
		numOne = scnr.nextInt();
		//second count array
		System.out.println("");
		ArrayList<Integer> countTwo = new ArrayList<Integer>();
		do {
			countTwo.add(scnr.nextInt());
		} while (scnr.hasNext());
		//second check array
		System.out.println("");
		int numTwo = 0;
		numTwo = scnr.nextInt();
		
		//first operation array
		System.out.println("");
		ArrayList<Integer> operationOne = new ArrayList<Integer>();
		do {
			operationOne.add(scnr.nextInt());
		} while (scnr.hasNext());
		//first operation string
		System.out.println("");
		String stringOne = null;
		stringOne = scnr.next();
		//second operation array
		System.out.println("");
		ArrayList<Integer> operationTwo = new ArrayList<Integer>();
		do {
			operationTwo.add(scnr.nextInt());
		} while (scnr.hasNext());
		//second operation string
		System.out.println("");
		String stringTwo = null;
		stringTwo = scnr.next();
		//third operation array
		System.out.println("");
		ArrayList<Integer> operationThree = new ArrayList<Integer>();
		do {
			operationThree.add(scnr.nextInt());
		} while (scnr.hasNext());
		//third operation string
		System.out.println("");
		String stringThree = null;
		stringThree = scnr.next();
		
		//first binary array
		System.out.println("");
		ArrayList<Integer> binaryOne = new ArrayList<Integer>();
		do {
			binaryOne.add(scnr.nextInt());
		} while (scnr.hasNext());
		//second binary array
		System.out.println("");
		ArrayList<Integer> binaryTwo = new ArrayList<Integer>();
		do {
			binaryTwo.add(scnr.nextInt());
		} while (scnr.hasNext());
		
		//first palindrome array
		System.out.println("");
		ArrayList<Character> palindromeOne = new ArrayList<Character>();
		do {
			palindromeOne.add(scnr.next().charAt(0));
		} while (scnr.hasNext());
		//second palindrome array
		System.out.println("");
		ArrayList<Character> palindromeTwo = new ArrayList<Character>();
		do {
			palindromeTwo.add(scnr.next().charAt(0));
		} while (scnr.hasNext());
		
		System.out.println(countOccurrences(countOne, numOne));
		System.out.println(countOccurrences(countTwo, numTwo));
		
		System.out.println(mathOperation(operationOne, stringOne));
		System.out.println(mathOperation(operationTwo, stringTwo));
		System.out.println(mathOperation(operationThree, stringThree));
		
		System.out.println(binaryToDecimal(binaryOne));
		System.out.println(binaryToDecimal(binaryTwo));
		
		System.out.println(isPalindrome(palindromeOne));
		System.out.println(isPalindrome(palindromeTwo));
		*/
	}
	
}
