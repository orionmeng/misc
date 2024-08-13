///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Command Line
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

public class CommandLine {
	
	public static void main(String[] args) {
		
		if (args.length > 2 || args.length == 0) {
			System.out.print("usage: java CommandLine.java [squareSide] or java CommandLine.java [rectangleSide1] [rectangleSide2]");
		}
		if (args.length == 2) {
			int int1 = 0;
			int int2 = 0;
			int1 = (new Integer(args[0])).intValue();
			int2 = (new Integer(args[1])).intValue();
			commandGet(int1, int2);
		}
		if (args.length == 1) {
			int int1 = 0;
			int1 = (new Integer(args[0])).intValue();
			commandGet(int1);
		}
		
	}
	
	public static void commandGet(int integer) {
		System.out.print(integer * integer);
	}
	
	public static void commandGet(int int1, int int2) {
		System.out.print(int1 * int2);
	}
	
}
