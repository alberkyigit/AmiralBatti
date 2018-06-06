import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserProcess {
	public static boolean Login(String name, StartGame gamer) throws IOException
	 {
		 boolean userState = false;
		 String userInfo = null;
		
		 File file = new File("AmiralBattiInfo.txt");
		 
		 BufferedReader in = new BufferedReader(new FileReader(file));
		 
		 String line;

		 while((line = in.readLine()) != null)
		 {
		    if(line.contains(name)) {
		    	userState = true;
		    	userInfo=line;
		    	break;
		    }
		 }
		 
		 in.close();
		 
		 if(!userState)
		 {
			 System.out.println("Kullanici bulunamadi!");
			 return false;
		 }
		 else
		 {
			gamer.setName(name);
			
			String slevel=userInfo.substring(userInfo.indexOf("(")+1, userInfo.indexOf(")"));
			
			int level=Integer.parseInt(slevel);
			
			gamer.setLevel(level);
			
			String diff = userInfo.substring(userInfo.indexOf(" ")+1, userInfo.lastIndexOf("("));
			
			gamer.setDifficult(diff);
			
			if(gamer.getDifficult().equals("easy")) {
				StartGame.arraysize = 10;
			}
			else if(gamer.getDifficult().equals("normal")) {
				StartGame.arraysize = 15;
			}
			else{
				StartGame.arraysize = 20;
			}
			
			return true;
		 }	
	 }
	 
	public static void CreateUser(String name, StartGame gamer) throws IOException
	 {
		 boolean userState = false;
		 
		 File file = new File("AmiralBattiInfo.txt");
		 
		 BufferedReader in = new BufferedReader(new FileReader(file));
		 
		 String line;

		 while((line = in.readLine()) != null)
		 {
		    if(line.contains(name)) {
		    	userState = true;
		    	break;
		    }    
		 }
			in.close();
			if(userState)
			{
				System.out.println("Bu kullanici mevcut. Lutfen baska bir isim giriniz: ");
				
				String yeniad = StartGame.scan.next();
		    	CreateUser(yeniad, gamer);
			}
			else {
				 String userInfo = "\n"+ name + " easy(0)";
				 FileWriter writer = new FileWriter(file,true);
                
				 BufferedWriter write = new BufferedWriter(writer);
                
				 write.write(userInfo);
                
				 write.close();
                
				 gamer.setName(name);
                
				 StartGame.arraysize = 10;
                
				 System.out.println("Kullanici olusturulmuþtur.");
			}
	 }

}
