import java.io.IOException;
import java.util.Scanner;

public class Menu {
	public static Scanner scan = new Scanner(System.in);
	
	public static boolean state;
	
	 public static  void WriteMenu() throws IOException
	 {
		state = false;
		
		do {
			StartGame gamer = new StartGame();
			
			System.out.println("\n-----------------------------");
			System.out.println("MENU");
			System.out.println("1. Login");
			System.out.println("2. Create new user");
			System.out.println("3. Exit");
			System.out.println("-----------------------------\n");
			
			int choose;
			
			String name;
			
			choose = scan.nextInt();
			
			if(choose == 1) {
				System.out.println("Kullanici Adi Giriniz: ");
				
			 	name = scan.next();
			 	
			 	if(UserProcess.Login(name, gamer)) {
			 		StartingProcess.Start(gamer);
			 		state = false;
			 	}
			 	else
			 	{
			 		state = true;
			 	}
			}
			else if(choose == 2) {
				System.out.println("Yeni Kullanici Adi Giriniz: ");
				
				name = scan.next();
			 	
				UserProcess.CreateUser(name, gamer);
			 	 
			 	gamer.setLevel(0);
			 	
			 	gamer.setDifficult("easy");
				
			 	StartingProcess.Start(gamer);
				
			 	state = false;
			}
			else if(choose == 3) {
				System.out.println("Program durduruldu.");
				 
				 System.exit(0);
			}
			else {
				state = true;
			}
			 
		}while(state);
	 }

	 public static int[] WriteGun(StartGame gamer) {
		 int gunType; 
		 int xAxin;
		 int yAxin;
		 int yIsAxin = 0;
		 
		 do {
			 if(StartGame.guns[0] != 0) {
				 System.out.println("0. Rocket " + StartGame.guns[0]);
			 }
			 if(StartGame.guns[1] != 0) {
				 System.out.println("1. Hand Bomb " + StartGame.guns[1]);
			 }
			 if(StartGame.guns[2] != 0) {
				 System.out.println("2. Gun Shot " + StartGame.guns[2]);
			 }
			 System.out.println("Select weapon: ");
			 gunType = scan.nextInt();
		 }while(!ControllProcess.GunControll(gunType));
		 
		 if(gunType == 1)
		 {
			 do {
			 System.out.println("0. Dikey");
			 System.out.println("1. Yatay");
			 System.out.println("Atis yapilacak duzlemi seciniz:");
			 yIsAxin = scan.nextInt();
		 	}while(!ControllProcess.PlaneControll(yIsAxin));
		 }
		 
		 do{
			 System.out.println("X coordinate to shoot: ");
			 xAxin = scan.nextInt();
			 System.out.println("Y coordinate to shoot: ");
			 yAxin = scan.nextInt();
		 }while(!ControllProcess.CoordinateControll(xAxin, yAxin, gamer.grid.length));
		 
		 return new int[] {gunType,xAxin, yAxin, yIsAxin };
	 }
	 
}