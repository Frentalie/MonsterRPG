import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 * @author Spencer
 * @version 1.0
 *
 */
public class MonsterRPG implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
		int[] resources = new int[3];
		for (int counter = 0; counter < resources.length; counter++)
			resources[counter] = 6;
		String[] resourcename = new String[] { "Cured Meat", "Health Potion", "Teddy Bear" };
		int days = 0;
		String option = "X";
		int[][] stats = new int[][] { { 100, 100, 100 }, { 100, 100, 100 }, { 100, 100, 100 } };
		File Gametext = new File("Gamestat.ser");
		Property property = new Property();
		if (!Gametext.exists())
			property.WritingFile(stats, resources, days, Gametext);
		//================================================//Reads file
		FileInputStream fileStream = new FileInputStream(Gametext);
		ObjectInputStream objectStream = new ObjectInputStream(fileStream);
		days = (int) objectStream.readObject();
		resources = (int[]) objectStream.readObject();
		stats = (int[][]) objectStream.readObject();
		objectStream.close();
		//================================================//
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			property.WritingFile(stats, resources, days, Gametext);
			System.out.println(" ***What would you like to do?***");
			System.out.println("===================================     _________");
			System.out.println(" =>>\t A. Explore            <<=    /   _____/");
			System.out.println(" =>>\t B. Storage/Resources  <<=    \\_____  \\ ");
			System.out.println(" =>>\t C. View Stats         <<=    /        \\");
			System.out.println(" =>>\t D. Sleep              <<=   /_______  /");
			System.out.println("===================================          \\/ ");
			option = scanner.next().toUpperCase();
			switch (option) {
			case "A":
				Explore explore = new Explore();
				explore.explore(stats, resources);
				break;
			case "B":
				UseResources Resources = new UseResources();
				Resources.viewresource(resources, resourcename, stats);
				break;
			case "C":
				ViewStats stats1 = new ViewStats();
				stats1.stats(stats);
				break;
			case "D":
				Sleep sleep = new Sleep();
				days = sleep.sleep(days, stats);
				break;
			default:
				System.out.println("Invalid Option!");
			}
		} while ("ABCD".indexOf(option) == -1 || days != 100);
		if (days == 100) {
			System.out.println("==========================================");
			System.out.println("\t\t\t\t\t\t\t\tYou have survived 100 days in the forest...");
			System.out.println("==========================================");
			System.out.println("\t\t\t\t\t\t\t\tThe rescue team came and found the remaining survivors:");
		}
	}
}
