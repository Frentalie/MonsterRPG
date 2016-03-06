package humans;

public class Humans {

	protected int sattack;
	protected int shunger;
	protected int smood;
	protected int mxhealth;

	public int attack(int power, int lvl) {
		sattack = (int) Math.round(power * (lvl * 0.1 + 1));//gives attack power
		return sattack;
	}

	public int hunger(int power, int lvl) {
		shunger = (int) Math.round(power * (1 - lvl * 0.02));//gives amount of hunger spent
		return shunger;
	}

	public int mood(int power, int lvl){
		smood = (int) Math.round(power*(1 - lvl*0.1));//gives how much the mood lowers
		return smood;
	}

	public int health(int power, int lvl){
		mxhealth = (int) Math.round(power*(lvl*0.12 + 1));//gives the max/min health
		return mxhealth;
	}
}

