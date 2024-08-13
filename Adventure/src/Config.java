///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Adventure Config.java
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

/**
 * This file contains constants for the text Adventure project. Also at the bottom of this file
 * are READ ME Notes for the Grader.
 *
 * @author Jim Williams
 * @author Orion Meng
 */
public class Config {

    /**
     * Indexes into coordinate arrays specifying a location in the map.
     */
    public static final int ROW = 0;
    public static final int COLUMN = 1;

    /**
     * Indexes into the fields/attributes array for each map location (3rd dimension of
     * the map array)
     */
    public static final int NAME = 0;
    public static final int ENTER_TEXT = 1;
    public static final int ENTER_RESULT = 2;
    public static final int NEARBY_TEXT = 3;
    //add additional indexes here for additional field information added to each configuration
    //line.

    /**
     * Values within the location fields/attributes that are used for game logic other than
     * simply printing out.
     */
    //In name field, designates the starting location of the player
    public static final String NAME_START = "start";

    //The result of the player entering the field.
    public static final String RESULT_RANDOM_MOVE = "randomMove";
    public static final String RESULT_WIN = "win";
    public static final String RESULT_LOSE = "lose";
    //add additional game logic fields here (not text fields that are simply printed).

    /**
     * Values used by the player to navigate through the map.
     */
    public static final String MOVE_UP = "w";
    public static final String MOVE_DOWN = "s";
    public static final String MOVE_LEFT = "a";
    public static final String MOVE_RIGHT = "d";
    public static final String NEARBY = "n";
    public static final String QUIT = "q";
    //add additional game control characters here, throwing, shooting, etc.

}

/*
Your READ ME notes to the Grader
Describe your enhancements to the program, map, etc. here.  You may include a link to a
YouTube video of a maximum of 2 minutes demonstrating your program.

0) Overview of your changes or a YouTube video link (max 2 minutes)

	edited loadAdventure method; added "src/" to the file string (same for writeMap method)
	edited the main method; changed "wumpus.advcfg" to "cake.advcfg"
	edited the main method; set boolean debug to true
	implemented writeMap method; includes a key to better read the map
	implemented parseCoordinates method; returns null if string exceeds length of five
	implemented parseFields method; returns based off length of string
	implemented determineLocation method; checks location on map before determining location
	implemented enter method; returns false if string is not caught by if-else statements
	designed map.advcfg

1) Configuration Example: Contents of your own configuration (.advcfg) file

	map is 49 square units in size (7 by 7)
	4/49 of the squares are losing squares
	2/49 of the squares are winning squares
	9/49 of the squares will move the player to a different square
	25/49 of the squares are open squares
	8/49 of the squares have random messages with no consequence
	1/49 of the squares is the starting square

2) Configuration Description: Describe unique elements in your configuration file

	contains many different neutral squares (useless armor, useless stick, etc.)
	contains potions which move the player to a different location
	contains cake monsters which kill the player
	contains poisonous cakes which kill the player
	contains cakes which signify victory when obtained by the player

3) writeMap Output: Example output of the writeMap method for your configuration file.

	 +-0-1-2-3-4-5-6-+
	0| S R * * * * * |
	1| * * R * R W * |
	2| R * * L N * R |
	3| * R * * * L * |
	4| N L L R * N N |
	5| N * W * * R * |
	6| * R * N N * N |
	 +---------------+
	 S-start
	 W-win
	 L-lose
	 R-random
	 N-neutral
	 ?-bug

4) Choose at least 1 of the following ways you extended the game and describe them:
  a) Tools: added your own tools/weapons and use of them in the game
  b) Audio: playing of audio files when sensing the neighbors, rather than simply text
  c) Test Cases: adding test cases to TestAdventure that thoroughly test the methods you wrote.
  d) Your Own: describe any other changes or additions we should consider for credit.

	test cases have been created for three different methods
	-testParseFields() has 4 tests
	-testDetermineLocation() has 8 tests
	-testEnter() has 5 tests
	each method has numbered tests to better locate errors
	each test has a comment that identifies what is being tested

 */
