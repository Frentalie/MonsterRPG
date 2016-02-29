import java.util.Random;
import java.util.Scanner;
public class ExploreSystem {

	static boolean Menu(int[][] stats, int who, int[] mhealth, Random dice, String name, int[] resources) throws InterruptedException{
		String action = "D";
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("       Choose a action!");
			System.out.println("+++++++++++++++++++++++++++++++");
			System.out.println("\tA. Attack!");
			System.out.println("\tB. Use a health potion!");
			System.out.println("\tC. View Description");
			System.out.println("\tD. Run Away!");
			System.out.println("+++++++++++++++++++++++++++++++");
			action = scanner.next().toUpperCase();
			if("ABCD".indexOf(action)==-1)
			{
				System.out.println("Invalid Option!");
			}
		}while("ABCD".indexOf(action)==-1);
		if(action.equals("A"))
		{ 
			boolean evade[] = new boolean[]{true, false};
			int attack = dice.nextInt((14 - 7) + 1) + 7;
			if(name.equals("Assassin"))
				Skills.Passive(evade, dice, name, null, 0, 0, null);
			if(evade[0]==false || evade[1]==false){
				System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
				System.out.printf("You >> You have dealt %d points of damage to the %s!%n", attack, name);
				mhealth[0]-=attack;
				if(mhealth[0]<0)
					mhealth[0] = 0;
				System.out.printf("%s >> The %s has %d health points remaining!%n",name, name, mhealth[0]);
				System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>\n");
			}
		}
		else if(action.equals("B"))
		{
			System.out.println("*********************************************************");
			if(resources[1]<=0){
				System.out.println("You don't have any health potions left!");
				System.out.println("*********************************************************");
				return ExploreSystem.Menu(stats, who, mhealth, dice, name, resources);
			}
			else
			{
				stats[who][0]+=20;
				System.out.printf("You recovered 20 health points from the potion!:%d%n", stats[who][0]);
				resources[1]-=1;
				System.out.printf("You have %d health options left!%n", resources[2]);
			}
			System.out.println("*********************************************************");

		}
		else if(action.equals("C"))
		{
			MobDes.ViewMobDes(name);
			return ExploreSystem.Menu(stats, who, mhealth, dice, name, resources);
		}
		else
		{
			System.out.println("*~*~*~*You attempt to run away!*~*~*~*");
			boolean run = dice.nextBoolean();
			Thread.sleep(1000);
			if(run==false)
				System.out.println("*~*~*~*You failed to escape from the battle!*~*~*~*");
			else
				System.out.println("*~*~*~*You have escaped the battle successfully!*~*~*~*");
			return run;	
		}
		return false;
	}
}
