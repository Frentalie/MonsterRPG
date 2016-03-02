
public class MobDes {

	static void ViewMobDes(String name) throws InterruptedException{
		Thread.sleep(500);
		System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
		switch(name)
		{
		case "Solider":
			System.out.println("Name - Solider");
			System.out.println("Health Range: 30 ~ 23 health points");
			System.out.println("Attack Strength: 18 ~ 24 health points");
			System.out.println("Special: Bandages - Heals 20% of its remaining health");
			break;
		case "Wizard":
			System.out.println("");
			break;
		case "Assassin":
			System.out.println("Name - Assassin");
			System.out.println("Health Range: 25 ~ 18 health points");
			System.out.println("Attack Strength: 12 ~ 7 health points");
			System.out.println("Special: Evade - 25% chance to dodge incoming attacks");
			break;

		}
		System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
		Thread.sleep(500);
	}

}
