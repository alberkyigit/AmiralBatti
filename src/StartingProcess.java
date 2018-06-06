import java.util.Scanner;

public class StartingProcess {
	public static Scanner scan = new Scanner(System.in);
	
	public static void Start(StartGame gamer)
	 {
		 int continueChoose = 0;
		 boolean continueState = true;
		 
		 gamer.grid = new String[StartGame.arraysize][StartGame.arraysize];
		 
		 do {	 
			 System.out.println("--- Oyun Basladi ---");
			 System.out.println("Oyuncu: " + gamer.getName() + " Zorluk: " + gamer.getDifficult() + " Level: " +  gamer.getLevel());
			 
			 GridProcess.CreateGrid(gamer.grid, gamer.getDifficult());
			 
			 GridProcess.WriteGrid(gamer.grid);
			 
			 do {
				 
				 ShipProcess.Fire(Menu.WriteGun(gamer), gamer);
				 if(ControllProcess.FinishControll(gamer))
				 {
					 ShipProcess.LevelChange(gamer);
					 break;
				 }
				 if(!ControllProcess.GunsControll())
				 {
					break;
				 }
			 }while(true);
			 
			 System.out.println("\n0. Evet");
			 System.out.println("1. Hayir");
			 
			 System.out.println("Devam etmek istiyor musunuz?");
			 continueChoose = scan.nextInt();
			 if(continueChoose == 1) continueState = false;
			 
		 }while(continueState);
		 
		 System.out.println("Program Sonlandirildi.");
		 
		 FileControll.FileUpdate(gamer);
	 }
	
}
