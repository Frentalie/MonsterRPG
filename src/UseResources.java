import java.util.Arrays;
import java.util.Scanner;

public class UseResources {

	protected void viewresource(int resources[], String resourcename[], int[][] stats) throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String whattodo;
		Arrays.sort(resourcename);
		do {
			System.out.println("===========================================");
			System.out.println("||	A. View/Use Resources		 ||");
			System.out.println("||	B. View Resource Description     ||");
			System.out.println("||	C. Exit Resources Menu		 ||");
			System.out.println("===========================================");
			whattodo = scanner.next().toUpperCase();
		} while ("ABCD".indexOf(whattodo) == -1);
		switch (whattodo) {
		case "A":
			Thread.sleep(600);
			useresource(resources, resourcename, stats);
			break;
		case "B":
			Thread.sleep(600);
			resourcedes();
			break;
		case "C":
			System.out.println("You have chose to exit the menu...");
			Thread.sleep(1000);
			break;
		default:
			System.out.println("Invalid Option!");
		}
	}

	private void useresource(int resources[], String resourcename[], int[][] stats) throws InterruptedException {
		String[] letter = new String[] { "A", "B", "C", "D", "E" };
		String[] which = new String[resources.length];
		String[] selectname = new String[resourcename.length];
		boolean itemchoice = false;
		String correct = "C";
		int counter2 = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String use = "A";
		int counter = -1;
		System.out.println("===========================================");
		System.out.println("Below are the resources you currently have:");
		System.out.println("-------------------------------------------");
		for (String y : resourcename) {
			++counter;
			try {
				if (resources[counter] != 0) {
					System.out.printf("          %s. %s: %d%n", letter[counter2], y, resources[counter]);
					which[counter2] = letter[counter2];
					selectname[counter2] = y;
					++counter2;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
		if (counter2 == 0)
			System.out.println("|  Apparently your storage is empty! :P   |");
		System.out.println("===========================================");
		if (counter2 != 0) {
			String exit;
			do {
				System.out.println("≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈");
				System.out.println("\t    A. Use Item");
				System.out.println("\t    B. Exit Menu");
				System.out.println("≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈");
				exit = scanner.next().toUpperCase();
				if (exit.equals("B")) {
					System.out.println("You have chose to exit the menu...");
					Thread.sleep(1000);
				} else if (!exit.equals("A"))
					System.out.println("Invalid Option!");
			} while ("AB".indexOf(exit) == -1);
			while (itemchoice == false && !use.equals("Z") && exit.equals("A")) {
				System.out.println("=========================================================");
				System.out.println("Which item would you like to use?(type Z to exit)");
				System.out.println("==========================================================");
				use = scanner.next().toUpperCase();
				for (int z = 0; z < resourcename.length; z++) {
					if (use.equals(which[z])) {
						do {
							itemchoice = true;
							System.out.printf("You have selected the item %s. Are you sure? Y/N %n", selectname[z]);
							correct = scanner.next().toUpperCase();
							switch (correct) {
							case "Y":
								ResourceUsage(resources, resourcename, stats, z);
								Thread.sleep(500);
								break;
							case "N":
								System.out.println("...");
								Thread.sleep(500);
								useresource(resources, resourcename, stats);
								break;
							default:
								System.out.println("Invalid Option!");
							}
						} while ("YN".indexOf(correct) == -1);
					}

				}
				if (itemchoice == false && !use.equals("Z"))
					System.out.println("Invalid Option!");
				else if (use.equals("Z"))
					System.out.println("You have chose to exit the Storage/Resources Menu.");
			}
		}

	}

	private void resourcedes() {

	}

	private void ResourceUsage(int resources[], String resourcename[], int[][] stats, int whichres) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean exception;
		String amountstring;
		String who;
		do{
		System.out.println("Who would you like to use it on?");
		System.out.println("==================================");
		System.out.println("&\t   A. Simon              &");
		System.out.println("&\t   B. Lily               &");
		System.out.println("&\t   C. Axel               &");
		System.out.println("==================================");
		who = scanner.next().toUpperCase();
		if("ABC".indexOf(who)==-1)
			System.out.println("Invalid Option!");
		}while("ABC".indexOf(who)==-1);

		do {
			try {
				exception = false;
				amountstring = "1";
				System.out.println("==================================");
				System.out.println("\tAmount?");
				System.out.println("==================================");
				amountstring = scanner.next();
				int amount = Integer.valueOf(amountstring);
				if (amount > resources[whichres]) {
					System.out.println("You do not have that amount of that item!");
					exception = true;
				}
			} catch (NumberFormatException e) {
				exception = true;
				System.out.println("Invalid Option!");
			}
		} while (exception == true);
	}
}
