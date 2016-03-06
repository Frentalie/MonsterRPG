import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import humans.Axel;
import humans.Lily;
import humans.Simon;

public class Property implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4892302064971929853L;

	void WritingFile(int[][] stats, int[] resources, int days, File Gametext)
			throws IOException, ClassNotFoundException {
		Simon Simon  = new Simon();
		Lily Lily  = new Lily();
		Axel Axel = new Axel();
		if (Gametext.exists())
			System.out.println("Your game has been saved!");
		else 
			System.out.println("Save file created!");
		FileOutputStream fileStream = new FileOutputStream(Gametext);
		ObjectOutputStream outputStream = new ObjectOutputStream(fileStream);
		outputStream.writeObject(days);
		outputStream.writeObject(resources);
		outputStream.writeObject(stats);
		outputStream.writeObject(Simon);
		outputStream.writeObject(Lily);
		outputStream.writeObject(Axel);
		fileStream.close();
		outputStream.close();
	}

}