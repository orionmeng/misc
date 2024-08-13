///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Word Search
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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordSearch {
	public static void main(String[] args) {

		// testReadDictionary();
		// testReadWordSearch();
		// testSearchHorizontal();
		// testSearchVertical();
		// testSearchDiagonal();

	}

	/**
	 * Opens and reads a dictionary file returning a list of words. Example: dog cat
	 * turtle elephant
	 * 
	 * If there is an error reading the file, such as the file cannot be found, then
	 * the following message is shown: Error: Unable to read file
	 * <dictionaryFilename> with <dictionaryFilename> replaced with the parameter
	 * value.
	 * 
	 * @param dictionaryFilename The dictionary file to read.
	 * @return An ArrayList of words.
	 */
	public static ArrayList<String> readDictionary(String dictionaryFilename) {
		ArrayList<String> dictionaryWords = new ArrayList<String>();
		FileInputStream wordBlocks = null;
		Scanner scanBlocks = null;
		try {
			wordBlocks = new FileInputStream(dictionaryFilename);
		} catch (Exception e) {
			System.out.println("Error: Unable to read file " + dictionaryFilename);
		}
		scanBlocks = new Scanner(wordBlocks);
		do {
			dictionaryWords.add(scanBlocks.next());
		} while (scanBlocks.hasNext());
		return dictionaryWords;
	}

	/**
	 * Opens and reads a wordSearchFileName file returning a block of characters.
	 * Example: jwufyhsinf agzucneqpo majeurnfyt
	 * 
	 * If there is an error reading the file, such as the file cannot be found, then
	 * the following message is shown: Error: Unable to read file
	 * <wordSearchFileName> with <wordSearchFileName> replaced with the parameter
	 * value.
	 * 
	 * @param wordSearchFileName The dictionary file to read.
	 * @return A 2d-array of characters representing the block of letters.
	 */
	public static char[][] readWordSearch(String wordSearchFileName) {
		char[][] blockOfLetters;
		FileInputStream letterBlocks = null;
		Scanner scanLetters = null;
		try {
			letterBlocks = new FileInputStream(wordSearchFileName);
		} catch (Exception e) {
			System.out.println("Error: Unable to read file " + wordSearchFileName);
		}
		scanLetters = new Scanner(letterBlocks);
		String nextBlock;
		nextBlock = scanLetters.nextLine();
		int nextBlockLength = 0;
		nextBlockLength = nextBlock.length();
		blockOfLetters = new char[100][nextBlockLength];
		int i = 0;
		do {
			for (int j = 0; j < nextBlock.length(); ++j) {
				blockOfLetters[i][j] = nextBlock.charAt(j);
			}
			nextBlock = scanLetters.nextLine();
			i += 1;
		} while (scanLetters.hasNext());
		for (int j = 0; j < nextBlock.length(); ++j) {
			blockOfLetters[i][j] = nextBlock.charAt(j);
		}
		/*
		 * int indexOfNull = Arrays.asList(blockOfLetters).indexOf(null); char[][]
		 * trimmedBlockOfLetters; trimmedBlockOfLetters = new
		 * char[indexOfNull][nextBlockLength]; for (int j = 0; j < indexOfNull; ++j) {
		 * for (int k = 0; k < nextBlockLength; ++k) { trimmedBlockOfLetters[j][k] =
		 * blockOfLetters[j][k]; } }
		 */
		/*
		 * int indexOfTrim = 0; boolean trimHere = true; for (int j = 0; trimHere; ++j)
		 * { if (blockOfLetters[j] == null || blockOfLetters[j].length == 0) {
		 * indexOfTrim = j; trimHere = false; } } char[][] trimmedBlockOfLetters;
		 * trimmedBlockOfLetters = new char[indexOfTrim][nextBlockLength]; for (int j =
		 * 0; j < indexOfTrim; ++j) { for (int k = 0; k < nextBlockLength; ++k) {
		 * trimmedBlockOfLetters[j][k] = blockOfLetters[j][k]; } }
		 */
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(wordSearchFileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error: Unable to read file " + wordSearchFileName);
		}
		int linesInFile = 0;
		try {
			while (reader.readLine() != null) {
				linesInFile += 1;
			}
		} catch (IOException e) {
			System.out.print("IOException");
		}
		char[][] trimmedBlockOfLetters = null;
		trimmedBlockOfLetters = new char[linesInFile][nextBlockLength];
		for (int j = 0; j < linesInFile; ++j) {
			for (int k = 0; k < nextBlockLength; ++k) {
				if (blockOfLetters[j] != null && blockOfLetters[j].length != 0) {
					trimmedBlockOfLetters[j][k] = blockOfLetters[j][k];
				}
			}
		}
		return trimmedBlockOfLetters;
	}

	public static void testReadDictionary() {
		ArrayList<String> testDictionary = null;
		testDictionary = readDictionary(
				"C:\\Users\\orion\\OneDrive\\Desktop\\workspace\\WordSearch\\src\\dictionary.txt");
		for (int i = 0; i < testDictionary.size(); ++i) {
			System.out.println(testDictionary.get(i));
		}
	}

	public static void testReadWordSearch() {
		char[][] testLetters = null;
		testLetters = readWordSearch("C:\\Users\\orion\\OneDrive\\Desktop\\workspace\\WordSearch\\src\\WordSearch.txt");
		for (int i = 0; i < testLetters.length; ++i) {
			for (int j = 0; j < testLetters[i].length; ++j) {
				System.out.print(testLetters[i][j]);
			}
			System.out.println("");
		}
	}

	/**
	 * Looks horizontally for the word in the word search, starting at the given
	 * position. If the given position matches the first character of word, look for
	 * the rest of the word characters in the indexes to the right and left
	 * 
	 * @param word       The word to look for.
	 * @param wordSearch The grid of characters to search through
	 * @param i          The row to start searching at
	 * @param j          The column to start searching at
	 * @return true if the word was found, false if not.
	 */
	public static boolean searchHorizontal(String word, char[][] wordSearch, int i, int j) {
		int wordLength = 0;
		wordLength = word.length();
		boolean isMatch = false;
		String stringRight = null;
		String stringLeft = null;
		stringRight = "";
		stringLeft = "";
		try {
			for (int k = j; k < j + wordLength; ++k) {
				stringRight = "" + stringRight + wordSearch[i][k];
			}
		} catch (Exception e) {
			stringRight = "doesnotexist";
		}
		try {
			for (int k = j; k > j - wordLength; --k) {
				stringLeft = "" + stringLeft + wordSearch[i][k];
			}
		} catch (Exception e) {
			stringLeft = "doesnotexist";
		}
		if (stringRight.equals(word) || stringLeft.equals(word)) {
			isMatch = true;
		}
		return isMatch;
	}

	/**
	 * Looks vertically for the word in the word search, starting at the given
	 * position. If the given position matches the first character of word, look for
	 * the rest of the word characters in the indexes above and below
	 * 
	 * @param word       The word to look for.
	 * @param wordSearch The grid of characters to search through
	 * @param i          The row to start searching at
	 * @param j          The column to start searching at
	 * @return true if the word was found, false if not.
	 */
	public static boolean searchVertical(String word, char[][] wordSearch, int i, int j) {
		int wordLength = 0;
		wordLength = word.length();
		boolean isMatch = false;
		String stringAbove = null;
		String stringBelow = null;
		stringAbove = "";
		stringBelow = "";
		try {
			for (int k = i; k > i - wordLength; --k) {
				stringAbove = "" + stringAbove + wordSearch[k][j];
			}
		} catch (Exception e) {
			stringAbove = "doesnotexist";
		}
		try {
			for (int k = i; k < i + wordLength; ++k) {
				stringBelow = "" + stringBelow + wordSearch[k][j];
			}
		} catch (Exception e) {
			stringBelow = "doesnotexist";
		}
		if (stringAbove.equals(word) || stringBelow.equals(word)) {
			isMatch = true;
		}
		return isMatch;
	}

	/**
	 * Looks diagonally (up-left, up-right, down-left and down-right) for the word
	 * in the word search, starting at the given position. If the given position
	 * matches the first character of the word, look for the rest of the word
	 * characters in the four diagonal directions.
	 * 
	 * @param word       The word to look for.
	 * @param wordSearch The grid of characters to search through
	 * @param i          The row to start searching at
	 * @param j          The column to start searching at
	 * @return true if the word was found, false if not.
	 */
	public static boolean searchDiagonal(String word, char[][] wordSearch, int i, int j) {
		int wordLength = 0;
		int holdi = 0;
		int holdj = 0;
		holdi = i;
		holdj = j;
		wordLength = word.length();
		boolean isMatch = false;
		String stringUpLeft = null;
		String stringUpRight = null;
		String stringDownLeft = null;
		String stringDownRight = null;
		stringUpLeft = "";
		stringUpRight = "";
		stringDownLeft = "";
		stringDownRight = "";
		try {
			for (int k = j; k > j - wordLength; --k) {
				stringUpLeft = "" + stringUpLeft + wordSearch[i][k];
				i -= 1;
			}
		} catch (Exception e) {
			stringUpLeft = "doesnotexist";
		}
		i = holdi;
		j = holdj;
		try {
			for (int k = j; k < j + wordLength; ++k) {
				stringUpRight = "" + stringUpRight + wordSearch[i][k];
				i -= 1;
			}
		} catch (Exception e) {
			stringUpRight = "doesnotexist";
		}
		i = holdi;
		j = holdj;
		try {
			for (int k = j; k > j - wordLength; --k) {
				stringDownLeft = "" + stringDownLeft + wordSearch[i][k];
				i += 1;
			}
		} catch (Exception e) {
			stringDownLeft = "doesnotexist";
		}
		i = holdi;
		j = holdj;
		try {
			for (int k = j; k < j + wordLength; ++k) {
				stringDownRight = "" + stringDownRight + wordSearch[i][k];
				i += 1;
			}
		} catch (Exception e) {
			stringDownRight = "doesnotexist";
		}
		i = holdi;
		j = holdj;
		if (stringUpLeft.equals(word) || stringUpRight.equals(word) || stringDownLeft.equals(word)
				|| stringDownRight.equals(word)) {
			isMatch = true;
		}
		/*
		 * System.out.println(word); System.out.println(stringUpLeft +
		 * " should be lhc"); System.out.println(stringUpRight + " should be lzz");
		 * System.out.println(stringDownLeft + " should be lyb");
		 * System.out.println(stringDownRight + " should be lry");
		 */
		return isMatch;
	}

	public static void testSearchHorizontal() {
		boolean test1 = false;
		boolean test2 = false;
		test1 = searchHorizontal("gay",
				readWordSearch("C:\\Users\\orion\\OneDrive\\Desktop\\workspace\\WordSearch\\src\\WordSearch.txt"), 5,
				5);
		test2 = searchHorizontal("gay",
				readWordSearch("C:\\Users\\orion\\OneDrive\\Desktop\\workspace\\WordSearch\\src\\WordSearch.txt"), 2,
				9);
		if (test1) {
			System.out.println("testH1 failed");
		} else {
			System.out.println("testH1 passed");
		}
		if (test2) {
			System.out.println("testH2 passed");
		} else {
			System.out.println("testH2 failed");
		}
	}

	public static void testSearchVertical() {
		boolean test1 = false;
		boolean test2 = false;
		test1 = searchVertical("cock",
				readWordSearch("C:\\Users\\orion\\OneDrive\\Desktop\\workspace\\WordSearch\\src\\WordSearch.txt"), 5,
				5);
		test2 = searchVertical("cock",
				readWordSearch("C:\\Users\\orion\\OneDrive\\Desktop\\workspace\\WordSearch\\src\\WordSearch.txt"), 8,
				0);
		if (test1) {
			System.out.println("testV1 failed");
		} else {
			System.out.println("testV1 passed");
		}
		if (test2) {
			System.out.println("testV2 passed");
		} else {
			System.out.println("testV2 failed");
		}
	}

	public static void testSearchDiagonal() {
		boolean test1 = false;
		boolean test2 = false;
		boolean test3 = false;
		boolean test4 = false;
		boolean test5 = false;
		test1 = searchDiagonal("gay",
				readWordSearch("C:\\Users\\orion\\OneDrive\\Desktop\\workspace\\WordSearch\\src\\WordSearch.txt"), 5,
				5);
		test2 = searchDiagonal("deo",
				readWordSearch("C:\\Users\\orion\\OneDrive\\Desktop\\workspace\\WordSearch\\src\\WordSearch.txt"), 13,
				3);
		test3 = searchDiagonal("shj",
				readWordSearch("C:\\Users\\orion\\OneDrive\\Desktop\\workspace\\WordSearch\\src\\WordSearch.txt"), 3,
				16);
		test4 = searchDiagonal("qxc",
				readWordSearch("C:\\Users\\orion\\OneDrive\\Desktop\\workspace\\WordSearch\\src\\WordSearch.txt"), 17,
				2);
		test5 = searchDiagonal("dye",
				readWordSearch("C:\\Users\\orion\\OneDrive\\Desktop\\workspace\\WordSearch\\src\\WordSearch.txt"), 17,
				17);
		if (test1) {
			System.out.println("testD1 failed");
		} else {
			System.out.println("testD1 passed");
		}
		if (test2) {
			System.out.println("testD2 passed");
		} else {
			System.out.println("testD2 failed");
		}
		if (test3) {
			System.out.println("testD3 passed");
		} else {
			System.out.println("testD3 failed");
		}
		if (test4) {
			System.out.println("testD4 passed");
		} else {
			System.out.println("testD4 failed");
		}
		if (test5) {
			System.out.println("testD5 passed");
		} else {
			System.out.println("testD5 failed");
		}
	}

}
