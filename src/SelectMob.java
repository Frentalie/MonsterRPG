import java.util.Random;
import java.util.Scanner;


public class SelectMob {

	static void SelectingMonster(int[][] stats, int who, int[] resources) throws InterruptedException{
		Thread.sleep(1500);
		int which;
		Random dice = new Random();
		Random monster = new Random();
		boolean newmob = true;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String YorN = "B";
		do{//while option equals Yes, repeat.
			which = monster.nextInt(9);
			which = 2;
			switch(which)
			{
			case 0:SelectMob.Wolf(stats, who, dice, newmob, resources);
			break;
			case 1:SelectMob.Bear(stats, who, dice, newmob, resources);
			break;
			case 2:SelectMob.Solider(stats, who, dice, newmob, resources);
			break;
			case 3:SelectMob.Wizard(stats, who, dice, newmob, resources);
			break;
			case 4:SelectMob.Assassin(stats, who, dice, newmob, resources);
			break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			}
			do{
				System.out.println("====================?");
				System.out.println("	A. Yes");
				System.out.println("	Countinue?");
				System.out.println("	B. No");
				System.out.println("====================?");
				YorN = scanner.next().toUpperCase();
				if("AB".indexOf(YorN)==-1)
					System.out.println("Invalid Option");
			}while("AB".indexOf(YorN)==-1);//if player does not select A or B, repeat.
		}while(YorN.equals("A"));
		newmob = true;
		Thread.sleep(1000);
	}
	private static void Wolf(int[][] stats, int who, Random dice, boolean newmob, int[] resources) throws InterruptedException{//done
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		String mstrength = "2~6";
		int mhealth[] = new int[]{dice.nextInt((14 - 9) + 1) + 9};//so we don't have to make the mod's health the return value.
		do{
			int mattack = dice.nextInt((6 - 2) + 1) + 2;//((max - min) + 1) + min)
			newmob = Dialogue(name, mhealth, mattack, stats, who, dice, mstrength, newmob, resources);
		}while(mhealth[0]!=0 && stats[who][0]!=0 && newmob==false);
	}
	private static void Bear(int[][] stats, int who, Random dice, boolean newmob, int[] resources) throws InterruptedException{//done, but might add more
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		String mstrength = "7~12";
		int mhealth[] = new int[]{dice.nextInt((25 - 18) + 1) + 18};//so we don't have to make the mod's health the return value.
		do{
			int mattack = dice.nextInt((12 - 7) + 1) + 7;
			newmob = Dialogue(name, mhealth, mattack, stats, who, dice, mstrength, newmob, resources);
		}while(mhealth[0]!=0 && stats[who][0]!=0 && newmob==false);
	}
	private static void Solider(int[][] stats, int who, Random dice, boolean newmob, int[] resources) throws InterruptedException{//done
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		String mstrength = "18~24";	
		boolean[] attack = new boolean[]{true};
		int mhealth[] = new int[]{dice.nextInt((30 - 23) + 1) + 23};//so we don't have to make the mod's health the return value.	
		int orighealth = mhealth[0];
		do{
			int mattack = dice.nextInt((24 - 18) + 1) + 18;
			newmob = Dialogue(name, mhealth, mattack, stats, who, dice, mstrength, newmob, resources);
			if(mhealth[0]!=0 && newmob==false)
			Skills.Passive(null, dice, name, mhealth, 0, orighealth, attack);
		}while(mhealth[0]!=0 && stats[who][0]!=0 && newmob==false);
	}
	private static void Wizard(int[][] stats, int who, Random dice, boolean newmob, int[] resources) throws InterruptedException{//not done
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		String mstrength = "7~12";
		int mhealth[] = new int[]{dice.nextInt((25 - 18) + 1) + 18};//so we don't have to make the mod's health the return value.
		do{
			int mattack = dice.nextInt((12 - 7) + 1) + 7;
			newmob = Dialogue(name, mhealth, mattack, stats, who, dice, mstrength, newmob, resources);
		}while(mhealth[0]!=0 && stats[who][0]!=0 && newmob==false);
	}
	private static void Assassin(int[][] stats, int who, Random dice, boolean newmob, int[] resources) throws InterruptedException{//not done
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		String mstrength = "18~27";
		int mhealth[] = new int[]{dice.nextInt((25 - 18) + 1) + 18};//so we don't have to make the mod's health the return value.
		do{
			int mattack = dice.nextInt((27 - 18) + 1) + 18;
			newmob = Dialogue(name, mhealth, mattack, stats, who, dice, mstrength, newmob, resources);
		}while(mhealth[0]!=0 && stats[who][0]!=0 && newmob==false);
	}
	static boolean Dialogue(String name, int[] mhealth, int mattack, int[][] stats, int who, Random dice, String mstrength, boolean newmob, int[] resources) throws InterruptedException{
		boolean run = false;
		if(newmob==true){
			newmob=false;
			System.out.println("============================");
			System.out.printf("You meet a %s!%n", name);
			System.out.printf("Health - %d points%n",mhealth[0]);
			System.out.printf("Strength - %s points%n", mstrength);
			System.out.println("============================");
		}
		run = HumanAttack.Menu(stats, who, mhealth, dice, name, resources);
		Thread.sleep(1000);
		if(mhealth[0]!=0 && run==false)
		{
			stats[who][0]-=mattack;
			System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
			System.out.printf("%s >> The %s has dealt %d points of damage to you!%n", name, name, mattack);
			System.out.printf("You >> You have %d health points remaining!%n", stats[who][0]);
			System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
		}
		else if(mhealth[0]==0 && run==false)
		{
			System.out.printf("~*~*~You have defeated the %s!~*~*~%n",name);
		}
		else
		{
			newmob=true;//basically if this equals true then it will not continue the while loop
		}
		return newmob;
	}
}
