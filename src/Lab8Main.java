import java.util.*;

public class Lab8Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		String[] students = { "Kelsey", "Clark", "Maurice", "Hilberto", "Todd", "Gunther", "Ignatius", "Larry",
				"Heatherford", "Resby" };
		String[] hometown = { "Oscarburg, Denmark", "Chesby, NC", "Gargoyleland, MN", "Alvindale, CA",
				"Fisherman's Cove, IA", "Drescole, Scotland", "Svazenstien, Austria", "Paradise Valley, NV",
				"T-Bone, NJ", "Manchester, France" };
		String[] favFood = { "oysters", "swordfish", "coconuts", "cow tongue", "zebra muscles", "flour", "salted quail",
				"corn chips", "jumbalya", "ancient cheese" };
		String knowMore = "";
		String anotherStudent = "";
		System.out.println("Welcome to our Java class.");

		do {
			int userChoice = getStudent(students);
			String moreInfo = studentInfo(students, userChoice);
			if (moreInfo.equalsIgnoreCase("hometown")) {
				knowMore = hometown(students, hometown, userChoice);
				if (knowMore.equalsIgnoreCase("yes")) {
					knowMore = favFood(students, favFood, userChoice);
					anotherStudent = knowMore;
				}
			} else if (moreInfo.equalsIgnoreCase("favorite food")) {
				knowMore = favFood(students, favFood, userChoice);
				if (knowMore.equalsIgnoreCase("yes")) {
					knowMore = hometown(students, hometown, userChoice);
					anotherStudent = knowMore;
				}
			} else anotherStudent = knowMore;
		} while (anotherStudent.equalsIgnoreCase("yes"));
		System.out.println("Thanks!");
	}

	public static int getStudent(String[] students) {
		System.out.println("Which student would you like to learn more about? (enter a number 1-10)");
		int i = 0;
		do {
			try {
				int input = scan.nextInt();
				i = input - 1;
				System.out.println("Student " + (i + 1) + " is " + students[i] + ". What would you like to know about "
						+ students[i] + "? (enter 'hometown' or 'favorite food'): ");
			} catch (IndexOutOfBoundsException | IllegalArgumentException | InputMismatchException e) {
				System.out.println("That student does not exist. Please enter a number 1 - 10");
				scan.nextLine();
			}
		} while ((i < 1) || (i > 10));
		scan.nextLine();
		return i;
	}

	public static String studentInfo(String[] students, int i) {
		String moreInfo = "";
		do {
			moreInfo = scan.nextLine();
			if (!moreInfo.equalsIgnoreCase("hometown") && !moreInfo.equalsIgnoreCase("favorite food")) {
				System.out.println("That data does not exist. Please enter 'hometown' or 'favorite food': ");
			}
		} while (!moreInfo.equalsIgnoreCase("hometown") && !moreInfo.equalsIgnoreCase("favorite food"));
		return moreInfo;
	}

	public static String hometown(String[] students, String[] hometown, int i) {
		System.out.println(
				students[i] + " is from " + hometown[i] + ". Would you like to know more? (enter 'yes' or 'no'): ");
		String knowMore = "";
		do {
			knowMore = scan.nextLine();
			if (!knowMore.equalsIgnoreCase("yes") && !knowMore.equalsIgnoreCase("no")) {
				System.out.println("Sorry, I didn't understand. Please enter 'yes' or 'no': ");
			}
		} while (!knowMore.equalsIgnoreCase("yes") && !knowMore.equalsIgnoreCase("no"));
		return knowMore;
	}

	public static String favFood(String[] students, String[] favFood, int i) {
		System.out.println(
				students[i] + " loves to eat " + favFood[i] + ". Would you like to know more? (enter 'yes' or 'no'): ");
		String knowMore = "";
		do {
			knowMore = scan.nextLine();
			if (!knowMore.equalsIgnoreCase("yes") && !knowMore.equalsIgnoreCase("no")) {
				System.out.println("Sorry, I didn't understand. Please enter 'yes' or 'no': ");
			}
		} while (!knowMore.equalsIgnoreCase("yes") && !knowMore.equalsIgnoreCase("no"));
		return knowMore;
	}
}
