///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Calendar
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

/**
 * This class contains the entire program to print out a yearly calendar.
 *
 * @author Jim Williams
 * @author Orion Meng
 */
public class Calendar {

	public static void insertFormatCharacters(char characterToInsert, int numTimesToInsert) {
		for (int i = 0; i < numTimesToInsert; i++) {
			System.out.print(characterToInsert);
		}
	}

	public static boolean testLeapYear(int testLeapYear2) {
		/**
		 * Every year that is exactly divisible by four is a leap year, except for years
		 * that are exactly divisible by 100, but these centurial years are leap years
		 * if they are exactly divisible by 400. For example, the years 1700, 1800, and
		 * 1900 are not leap years, but the years 1600 and 2000 are.
		 * https://en.wikipedia.org/wiki/Leap_year
		 */
		boolean yearTestingForLeap = false;
		if (testLeapYear2 % 4 == 0) {
			if (testLeapYear2 % 100 == 0) {
				if (testLeapYear2 % 400 == 0) {
					yearTestingForLeap = true;
				} else {
					yearTestingForLeap = false;
				}
			} else {
				yearTestingForLeap = true;
			}

		} else {
			yearTestingForLeap = false;
		}
		return yearTestingForLeap;
	}

	/**
	 * This returns the number of days in the specified month of year.
	 *
	 * @param month The month to return the number of days.
	 * @param year  The year is used for determining whether it is a leap year.
	 * @return The number of days in the specified month of the year.
	 */
	public static int getDaysInMonth(int month, int year) {
		int daysInMonth = 0;
		switch (month) {
		// 31 days
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			daysInMonth = 31;
			break;

		// 30 days
		case 4:
		case 6:
		case 9:
		case 11:
			daysInMonth = 30;
			break;

		case 2: // 28 or 29 days
			if (testLeapYear(year)) {
				daysInMonth = 29;
			} else {
				daysInMonth = 28;
			}
			break;
		}
		return daysInMonth;
	}

	/**
	 * Returns the name of the month, given the number of the month.
	 *
	 * @param month The month where 1 is January and 12 is December.
	 * @return The name of the month.
	 */
	public static String getMonthName(int month) {
		String monthStr;
		switch (month) {
		case 1:
			monthStr = "January";
			break;
		case 2:
			monthStr = "February";
			break;
		case 3:
			monthStr = "March";
			break;
		case 4:
			monthStr = "April";
			break;
		case 5:
			monthStr = "May";
			break;
		case 6:
			monthStr = "June";
			break;
		case 7:
			monthStr = "July";
			break;
		case 8:
			monthStr = "August";
			break;
		case 9:
			monthStr = "September";
			break;
		case 10:
			monthStr = "October";
			break;
		case 11:
			monthStr = "November";
			break;
		case 12:
			monthStr = "December";
			break;
		default:
			monthStr = "UNKNOWN";
			break;
		}
		return monthStr;
	}

	public static void formatPages(String nameOfMonth, int numOfYear) {
		final int TOTAL_WIDTH = 28;
		final char MONTH_HEADER_LINE_CHAR = '-';

		System.out.println();
		String monthAndYear = nameOfMonth + " " + numOfYear;
		int spacesBefore = (TOTAL_WIDTH - monthAndYear.length()) / 2;
		insertFormatCharacters(' ', spacesBefore);
		System.out.println(monthAndYear);
		insertFormatCharacters(MONTH_HEADER_LINE_CHAR, TOTAL_WIDTH);
		System.out.println();
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
	}

	public static void monthlyPages(int firstDayOfMonth, int numDaysInMonth) {
		final char CHAR_BETWEEN_DAYS = ' ';
		final int DAYS_IN_A_WEEK = 7;
		final int LOWEST_SINGLE_DIGIT_DAY = 1;
		final int HIGHEST_SINGLE_DIGIT_DAY = 9;

		insertFormatCharacters(CHAR_BETWEEN_DAYS, firstDayOfMonth * 4);
		for (int j = 1; j <= numDaysInMonth; j++) {
			if (j >= LOWEST_SINGLE_DIGIT_DAY && j <= HIGHEST_SINGLE_DIGIT_DAY) {
				insertFormatCharacters(CHAR_BETWEEN_DAYS, 2);
			} else {
				insertFormatCharacters(CHAR_BETWEEN_DAYS, 1);
			}
			System.out.print(j);
			insertFormatCharacters(CHAR_BETWEEN_DAYS, 1);
			firstDayOfMonth++;
			if (firstDayOfMonth % DAYS_IN_A_WEEK == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	/**
	 * This prompts for the year and the day of the week of January 1st and then
	 * prints out a calendar for the entire year.
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		final char FIRST_MONTH = 1;
		final char LAST_MONTH = 12;
		final int DAYS_IN_A_WEEK = 7;

		Scanner input = new Scanner(System.in);
		System.out.print("Enter year:");
		int year = input.nextInt();
		System.out.print("Enter day of week of Jan 1 (0-Sunday, 1-Monday, etc):");
		int startDay = input.nextInt();

		for (int month = FIRST_MONTH; month <= LAST_MONTH; ++month) {
			String monthName = getMonthName(month);
			formatPages(monthName, year);

			int daysInMonth = getDaysInMonth(month, year);
			monthlyPages(startDay, daysInMonth);

			startDay = (startDay + daysInMonth) % DAYS_IN_A_WEEK;
		}
	}
}
