import java.util.Random;

public class Skills {

	static void Passive(boolean[] evade, Random dice, String name, int[] mhealth, int mattack, int orighealth,
			boolean[] attack) {
		if (name.equals("Assassin")) {
			evade[0] = dice.nextBoolean();
			evade[1] = dice.nextBoolean();
			if (evade[0] == true && evade[1] == true) {
				System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
				System.out.println("Passive >> The Assassin has evaded your attack!");
				System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
			}
		} else if (name.equals("Solider")) {
			if (mhealth[0] < orighealth) {
				int recovery = (int) (mhealth[0] * 0.2);
				mhealth[0] += recovery;
				attack[0] = true;
				if (mhealth[0] > orighealth) {
					recovery = recovery - (mhealth[0] - orighealth);
					mhealth[0] = orighealth;
				}
				System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
				if (recovery == 0)
					System.out.println("Passive >> The solider's health is too low to be recovered!");
				else
					System.out.printf("Passive >> The solider has recovered %d health points!: %d%n", recovery,
							mhealth[0]);
				System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");

			}
		} else if (name.equals("Wizard")) {
			int throwpotion = dice.nextInt(3);
			int whichpotion = dice.nextInt(3);
			if (throwpotion == 1)
				System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");

			switch (whichpotion) {

			}

		}
	}
}
