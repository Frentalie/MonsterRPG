package humans;

import java.io.Serializable;

public class Axel extends Humans implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int xp;
	
	public Axel(int xp){
		this.xp = xp;
	}
	@Override
	public int mood(int power, int lvl) {
		smood = (int) Math.round(power*(1 - lvl*0.1));
		return smood;
	}
	public void xpup(int lvl){
	
	}
}
