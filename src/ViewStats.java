import java.util.Scanner;

import humans.Axel;
import humans.Humans;
import humans.Lily;
import humans.Simon;

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
				ViewStats.statshow(x[counter1][0],x[counter1][1],x[counter1][2],x[counter1][3], name);
				break;
			case "B":
				counter1=1;
				name = "Lily";
				ViewStats.statshow(x[counter1][0],x[counter1][1],x[counter1][2],x[counter1][3], name);
				break;
			case "C":
				counter1=2;
				name = "Axel";
				ViewStats.statshow(x[counter1][0],x[counter1][1],x[counter1][2],x[counter1][3], name);
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

	public static void statshow(int counter0, int counter1, int counter2, int counter3, String name){
		Simon Simon = new Simon();
		Humans model = new Humans();
		Lily Lily = new Lily();
		Axel Axel =new Axel();//use later
		System.out.println("===============================================================");
		System.out.printf("\t    Showing Stats of %s%n", name);
		System.out.println("---------------------------------------------------------------");
		if(name.equals("Simon"))
		System.out.println("\tHealth: " + counter0 + "/" +  Simon.health(100, counter3) +" pts.   Attack STR: " + Simon.attack(3, counter3) + " ~ " + Simon.attack(6, counter3));
		else if(name.equals("Lily"))
			System.out.println("\tHealth: " + counter0 + "/" +  Lily.health(100, counter3) +" pts.   Attack STR: " + Lily.attack(3, counter3) + " ~ " + Lily.attack(6, counter3));
		else
			System.out.println("\tHealth: " + counter0 + "/" +  Axel.health(100, counter3) +" pts.   Attack STR: " + Axel.attack(3, counter3) + " ~ " + Axel.attack(6, counter3));
		System.out.println("\tHunger: " + counter1 + "/100" + " pts.   Hunger Lower RT: Normal");
		if(name.equals("Axel") && counter3!=0)
		System.out.println("\tMood: " + counter2 + "/100" +" pts.    Mood Lower RT: " + (1 - counter3*0.1) + "%");
		else
		System.out.println("\tMood: " + counter2 + "/100" +" pts.     Mood Lower RT: Normal");
		System.out.println("\tLevel: " + ++counter3);
		System.out.println("================================================================");
	}
}
