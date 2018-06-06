import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileControll {
	public static void fileControllProcess() throws IOException
	 {
		 File file = new File("AmiralBattiInfo.txt");
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	 }

	 public static void FileUpdate(StartGame gamer) {
		 File inputFile = new File("AmiralBattiInfo.txt");
		 File tempFile = new File("myTempFile.txt");

		 try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			
			String currentLine;
			
			while((currentLine = reader.readLine()) != null) {
				if(currentLine.contains(gamer.getName()))
				{
					 String userInfo = gamer.getName() + " " + gamer.getDifficult() + "(" + gamer.getLevel() + ")";
					 writer.write(userInfo);
					 writer.newLine();
				}
				else
				{
					writer.write(currentLine);
					writer.newLine();	
				}
			}
			
			writer.close(); 
			reader.close();
			inputFile.delete();
			tempFile.renameTo(inputFile);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 }

}
