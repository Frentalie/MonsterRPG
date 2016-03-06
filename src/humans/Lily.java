package humans;

import java.io.Serializable;

public class Lily extends Humans implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int xp;
	public Lily(int xp){
		this.xp = xp;
	}
	@Override
	public int health(int power, int lvl) {
		mxhealth = (int) Math.round(power*(lvl*0.22 + 1));
		return mxhealth;
	}
}
