import java.util.Scanner;

public class Explore {


	public void explore(int[][] stats, int[] resources)throws InterruptedException{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int who = 0;
		String option = "";
		do{
			System.out.println("Who would you like to send to explore?");
			System.out.println("=======================================");
			System.out.println(" *\tA. Simon                     *");
			System.out.println(" *\tB. Lily                      *");
			System.out.println(" *\tC. Axel                      *");
			System.out.println(" *\tD. Exit Exploring            *");
			System.out.println("=======================================");
			option = scanner.next().toUpperCase();
			switch(option)
			{	
			case "A":System.out.println("You have sent Simon to explore the woods...");
			SelectMob.SelectingMonster(stats, who, resources);
			break;
			case "B":System.out.println("You have sent Lily to explore the woods...");
			who = 1;
			SelectMob.SelectingMonster(stats, who, resources);
			break;
			case "C":System.out.println("You have sent Axel to explore the woods...");
			who = 2;
			SelectMob.SelectingMonster(stats, who, resources);
			break;
			case "D":System.out.println("You have exited the explore menu.");
			break;
			default:System.out.println("Invalid Option!");
			}

		}while("ABCD".indexOf(option)==-1);
	}

}
