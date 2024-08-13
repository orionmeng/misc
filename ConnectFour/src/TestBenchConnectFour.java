///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Connect Four
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

public class TestBenchConnectFour {

    public static void main(String[] args) {
        testIsWinningCord();
    }

    public static void testIsWinningCord() {
        {//Vertical True
            int[][] board = {
                { 0,-1,-1,-1,-1,-1,-1},
                { 0,-1,-1,-1,-1,-1,-1},
                { 0,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1}
            };
            System.out.print("Vertical winning move test (Row: 3, Col: 0): " +
                               ConnectFour.isWinningCoord(3, 0, board, 0));
            System.out.println(" which should be true");
            ConnectFour.printGameBoard(board);
        }
        {//Diagonal Negative True
            int[][] board = {
                { 1, 1, 1, 0,-1,-1,-1},
                { 1, 1, 0,-1,-1,-1,-1},
                { 1, 0,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1}
            };
            System.out.print("Diagonal (neg) winning move test (Row: 3, Col: 0): " +
                               ConnectFour.isWinningCoord(3, 0, board, 0));
            System.out.println(" which should be true");
            ConnectFour.printGameBoard(board);
        }
        {//Diagonal Positive True
            int[][] board = {
                { 0, 1, 1, 1,-1,-1,-1},
                {-1, 0, 1, 1,-1,-1,-1},
                {-1,-1, 0, 1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1}
            };
            System.out.print("Diagonal (pos) winning move test (Row: 4, Col: 4): " +
                               ConnectFour.isWinningCoord(3, 3, board, 0));
            System.out.println(" which should be true");
            ConnectFour.printGameBoard(board);
        }
        {//Diagonal Negative False
            int[][] board = {
                { 1, 1, 1, 0,-1,-1,-1},
                { 1, 1, 0,-1,-1,-1,-1},
                { 1, 0,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1}
            };
            System.out.print("Diagonal (neg) winning move test (Row: 0, Col: 7): " +
                               ConnectFour.isWinningCoord(0, 7, board, 0));
            System.out.println(" which should be false");
            ConnectFour.printGameBoard(board);
        }
        {//Diagonal Positive False
            int[][] board = {
                { 0, 1, 1, 1,-1,-1,-1},
                {-1, 0, 1, 1,-1,-1,-1},
                {-1,-1, 0, 1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1}
            };
            System.out.print("Diagonal (pos) winning move test (Row: 0, Col: 7): " +
                               ConnectFour.isWinningCoord(0, 7, board, 0));
            System.out.println(" which should be false");
            ConnectFour.printGameBoard(board);
        }
        {//Horizontal Left Side
        	int[][] board = {
                    {-1, 0, 0, 0,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1}
                };
                System.out.print("Horizontal (left) winning move test (Row: 0, Col: 0): " +
                                   ConnectFour.isWinningCoord(0, 0, board, 0));
                System.out.println(" which should be true");
                ConnectFour.printGameBoard(board);
        }
        {//Horizontal Right Side
        	int[][] board = {
                    {-1, 0, 0, 0,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1}
                };
                System.out.print("Horizontal (right) winning move test (Row: 0, Col: 4): " +
                                   ConnectFour.isWinningCoord(0, 4, board, 0));
                System.out.println(" which should be true");
                ConnectFour.printGameBoard(board);
        }
        {//Horizontal Middle
        	int[][] board = {
                    { 0,-1, 0, 0,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1},
                    {-1,-1,-1,-1,-1,-1,-1}
                };
                System.out.print("Horizontal (middle) winning move test (Row: 0, Col: 1): " +
                                   ConnectFour.isWinningCoord(0, 1, board, 0));
                System.out.println(" which should be true");
                ConnectFour.printGameBoard(board);
        }
    }
    
}

