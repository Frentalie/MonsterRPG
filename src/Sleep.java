public class Sleep {

	public int sleep(int days, int stats[][]) throws InterruptedException{
		String[] name = new String[]{"Simon", "Lily", "Axel"};
		String[] state = new String[]{"Health", "Hunger", "Mood"};
		String warn = "Warning";
		boolean healthy = true;
		++days;
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.printf("Sleep >> You have survived %d days...%n", days);
		for(int counter = 0;counter<stats.length;counter++){
			for(int counter1 = 0;counter1<stats[counter].length;counter1++){
				if(stats[counter][counter1]<=15){
					System.out.printf("%s >> %s is critically low on %s!: %d%% %n",warn,name[counter], state[counter1], stats[counter][counter1]);
					Thread.sleep(700);
					healthy = false;
				}
				else if(stats[counter][counter1]<=25){
					System.out.printf("%s >> %s is very low on %s!: %d%% %n",warn,name[counter], state[counter1], stats[counter][counter1]);
					Thread.sleep(700);
					healthy = false;
				}
				else if(stats[counter][counter1]<=45){
					System.out.printf("%s >> %s is low on %s!: %d%% %n",warn,name[counter], state[counter1], stats[counter][counter1]);
					Thread.sleep(700);
					healthy = false;
				}
			}
		}
		Thread.sleep(1000);
		if(healthy==true){
			Thread.sleep(700);
			System.out.println("Sleep >> All of your team members are healthy!");
		} 
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		Thread.sleep(700);
		System.out.print("\033[H\033[2J");
		return days;
	}
}
