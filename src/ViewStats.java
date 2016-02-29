import java.util.Scanner;

public class ViewStats {
	@SuppressWarnings("resource")
	public void stats(int[][] x){
		int counter1;
		Scanner scanner = new Scanner(System.in);
		Boolean countinue = false;
		String name;
		do
		{
			countinue = false;
			System.out.println("Whose stats would you like to view?");
			System.out.println("==================================");
			System.out.println("&\t   A. Simon              &");
			System.out.println("&\t   B. Lily               &");
			System.out.println("&\t   C. Axel               &");
			System.out.println("&\t   D. Exit Menu          & ");
			System.out.println("==================================");
			String statsoption = scanner.next().toUpperCase();
			switch(statsoption)
			{	
			case "A":
				counter1=0;
				name = "Simon";
				ViewStats.statshow(x[counter1][0],x[counter1][1],x[counter1][2], name);
				break;
			case "B":
				counter1=1;
				name = "Lily";
				ViewStats.statshow(x[counter1][0],x[counter1][1],x[counter1][2], name);
				break;
			case "C":
				counter1=2;
				name = "Axel";
				ViewStats.statshow(x[counter1][0],x[counter1][1],x[counter1][2], name);
				break;
			case "D":System.out.println("You have choose to exit the Menu~~");
			return;
			default:System.out.println("===================================");
			System.out.println("\tInvalid Option!");
			System.out.println("===================================");	
			countinue = true;
			}
			if(countinue==false)
				countinue=null;
			while(countinue==null){
				System.out.println("Would you like to countinue? Y/N");
				String y = scanner.next().toUpperCase();
				switch(y)
				{
				case "Y":countinue=true;
				break;
				case "N":countinue=false;
				break;
				default:System.out.println("Not a option!");
				countinue=null;
				}

			}
		}while(countinue==true);

	}

	public static void statshow(int counter0, int counter1, int counter2, String name){
		System.out.println("===================================");
		System.out.printf("\tShowing Stats of %s%n", name);
		System.out.println("-----------------------------------");
		System.out.println("\tHealth: " + counter0 + "%");
		System.out.println("\tHunger: " + counter1 + "%");
		System.out.println("\tMood: " + counter2 + "%");
		System.out.println("===================================");
	}
}
