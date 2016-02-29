import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Property {
	void WritingFile() throws IOException{
		File newFile = new File("Properties.txt");
		if(newFile.exists())
			System.out.println("Properties text file is already created.");
		else
		{

			newFile.createNewFile();
			FileWriter fileW = new FileWriter(newFile);
			BufferedWriter buffW = new BufferedWriter(fileW);
			buffW.write("HELLO");
			System.out.println("Properties text file was successfully created!");
			buffW.close();
		}

	}
}
