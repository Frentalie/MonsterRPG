package humans;

import java.io.Serializable;

public class Simon extends Humans implements Serializable{
	/**
	 * 
	 */
	public Simon(int xp){
		this.xp = xp;
	}
	private static final long serialVersionUID = 1L;
	public int xp;
	@Override
	public int attack(int power, int lvl) {
		sattack = (int) Math.round((power*1.25) * (lvl * 0.2 + 1));
		return sattack;
	}
}
