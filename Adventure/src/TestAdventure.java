///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Adventure Test
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

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;

/**
 * This contains testing methods for the Adventure program.
 */
public class TestAdventure {

    /**
     * Uncomment testing methods to have them run.
     * @param args unused
     */
    public static void main(String[] args) {
        testParseCoordinates();
        testParseFields();
        testDetermineLocation();
        testEnter();
    }

    /**
     * Tests for the parseCoordinates method.
     */
    private static void testParseCoordinates() {
        boolean error = false;

        {   //example test:
            String coordinateString = "";
            int [] expected = null;
            int [] actual = Adventure.parseCoordinates(coordinateString);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testParseCoordinates 1) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        if ( error) {
            System.out.println("Error in testParseCoordinates.");
        } else {
            System.out.println("All tests in testParseCoordinates passed.");
        }
    }
    
    /**
     * Tests for the testParseFields method.
     */
    private static void testParseFields() {
        boolean error = false;

        {   //four fields test:
            String fieldInformation = "cake/this is a win/win/smell of sugar";
            String [] expected = new String[]{"cake","this is a win","win","smell of sugar"};
            String [] actual = Adventure.parseFields(fieldInformation);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testParseFields 1) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }
        
        {   //two fields test:
            String fieldInformation = "size/This is the size of the map//";
            String [] expected = new String[]{"size","This is the size of the map","",""};
            String [] actual = Adventure.parseFields(fieldInformation);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testParseFields 2) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }
        
        {   //whitespace fields test:
            String fieldInformation = " //  /";
            String [] expected = new String[]{"","","",""};
            String [] actual = Adventure.parseFields(fieldInformation);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testParseFields 3) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }
        
        {   //asterisk test:
            String fieldInformation = "*";
            String [] expected = new String[]{"*"};
            String [] actual = Adventure.parseFields(fieldInformation);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testParseFields 4) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        if ( error) {
            System.out.println("Error in testParseFields.");
        } else {
            System.out.println("All tests in testParseFields passed.");
        }
    }
    
    /**
     * Tests for the testDetermineLocation method.
     */
    private static void testDetermineLocation() {
        boolean error = false;

        {   //border up test:
            String[][][] map = new String[3][3][0];
            int [] currentLocation = {0,1};
            String direction = Config.MOVE_UP;
            int [] expected = new int[]{2,1};
            int [] actual = Adventure.determineLocation(map, currentLocation, direction);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testDetermineLocation 1) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }
        
        {   //border down test:
            String[][][] map = new String[3][3][0];
            int [] currentLocation = {2,1};
            String direction = Config.MOVE_DOWN;
            int [] expected = new int[]{0,1};
            int [] actual = Adventure.determineLocation(map, currentLocation, direction);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testDetermineLocation 2) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }
        
        {   //border left test:
            String[][][] map = new String[3][3][0];
            int [] currentLocation = {1,0};
            String direction = Config.MOVE_LEFT;
            int [] expected = new int[]{1,2};
            int [] actual = Adventure.determineLocation(map, currentLocation, direction);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testDetermineLocation 3) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }
        
        {   //border right test:
            String[][][] map = new String[3][3][0];
            int [] currentLocation = {1,2};
            String direction = Config.MOVE_RIGHT;
            int [] expected = new int[]{1,0};
            int [] actual = Adventure.determineLocation(map, currentLocation, direction);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testDetermineLocation 4) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }
        
        {   //center up test:
            String[][][] map = new String[3][3][0];
            int [] currentLocation = {1,1};
            String direction = Config.MOVE_UP;
            int [] expected = new int[]{0,1};
            int [] actual = Adventure.determineLocation(map, currentLocation, direction);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testDetermineLocation 5) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }
        
        {   //center down test:
            String[][][] map = new String[3][3][0];
            int [] currentLocation = {1,1};
            String direction = Config.MOVE_DOWN;
            int [] expected = new int[]{2,1};
            int [] actual = Adventure.determineLocation(map, currentLocation, direction);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testDetermineLocation 6) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }
        
        {   //center left test:
            String[][][] map = new String[3][3][0];
            int [] currentLocation = {1,1};
            String direction = Config.MOVE_LEFT;
            int [] expected = new int[]{1,0};
            int [] actual = Adventure.determineLocation(map, currentLocation, direction);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testDetermineLocation 7) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }
        
        {   //center right test:
            String[][][] map = new String[3][3][0];
            int [] currentLocation = {1,1};
            String direction = Config.MOVE_RIGHT;
            int [] expected = new int[]{1,2};
            int [] actual = Adventure.determineLocation(map, currentLocation, direction);
            if ( !Arrays.equals(expected,actual)) {
                System.out.println("testDetermineLocation 8) Expected: " + Arrays.toString( expected)
                        + " Actual: " + Arrays.toString( actual));
                error = true;
            }
        }

        if ( error) {
            System.out.println("Error in testDetermineLocation.");
        } else {
            System.out.println("All tests in testDetermineLocation passed.");
        }
    }
    
    /**
     * Tests for the testEnter method.
     */
    private static void testEnter() {
        boolean error = false;

        {   //null test:
        	String[][][] map = new String[3][3][4];
        	int [] location = {1,1};
        	Random rand = new Random(99);
        	map[1][1] = null;
            boolean expected = false;
            boolean actual = Adventure.enter(map, location, rand);
            if ( !(expected == actual)) {
                System.out.println("testEnter 1) Expected: " + expected
                        + " Actual: " + actual);
                error = true;
            }
        }
        
        {   //randomMove test:
        	String[][][] map = new String[3][3][4];
        	int [] location = {1,1};
        	Random rand = new Random(99);
        	map[1][1][Config.ENTER_TEXT] = "randomly selecting spot";
        	map[1][1][Config.ENTER_RESULT] = "randomMove";
        	map[0][0] = null;
        	map[2][2] = null;
            boolean expected = false;
            boolean actual = Adventure.enter(map, location, rand);
            if ( !(expected == actual)) {
                System.out.println("testEnter 2) Expected: " + expected
                        + " Actual: " + actual);
                error = true;
            }
        }
        
        {   //win test:
        	String[][][] map = new String[3][3][4];
        	int [] location = {1,1};
        	Random rand = new Random(99);
        	map[1][1][Config.ENTER_RESULT] = "win";
        	map[1][1][Config.ENTER_TEXT] = "you won";
            boolean expected = true;
            boolean actual = Adventure.enter(map, location, rand);
            if ( !(expected == actual)) {
                System.out.println("testEnter 3) Expected: " + expected
                        + " Actual: " + actual);
                error = true;
            }
        }
        
        {   //lose test:
        	String[][][] map = new String[3][3][4];
        	int [] location = {1,1};
        	Random rand = new Random(99);
        	map[1][1][Config.ENTER_RESULT] = "lose";
        	map[1][1][Config.ENTER_TEXT] = "you lost";
            boolean expected = true;
            boolean actual = Adventure.enter(map, location, rand);
            if ( !(expected == actual)) {
                System.out.println("testEnter 4) Expected: " + expected
                        + " Actual: " + actual);
                error = true;
            }
        }
        
        {   //randomText test:
        	String[][][] map = new String[3][3][4];
        	int [] location = {1,1};
        	Random rand = new Random(99);
        	map[1][1][Config.ENTER_RESULT] = "apple";
        	map[1][1][Config.ENTER_TEXT] = "banana";
            boolean expected = false;
            boolean actual = Adventure.enter(map, location, rand);
            if ( !(expected == actual)) {
                System.out.println("testEnter 5) Expected: " + expected
                        + " Actual: " + actual);
                error = true;
            }
        }

        if ( error) {
            System.out.println("Error in testEnter.");
        } else {
            System.out.println("All tests in testEnter passed.");
        }
    }
    
}
