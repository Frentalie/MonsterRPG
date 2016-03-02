import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Property implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4892302064971929853L;

	void WritingFile(int[][] stats, int[] resources, int days, File Gametext)
			throws IOException, ClassNotFoundException {
		if (Gametext.exists())
			System.out.println("Your game has been saved!");
		FileOutputStream fileStream = new FileOutputStream(Gametext);
		ObjectOutputStream outputStream = new ObjectOutputStream(fileStream);
		outputStream.writeObject(days);
		outputStream.writeObject(resources);
		outputStream.writeObject(stats);
		fileStream.close();
		outputStream.close();
	}

}