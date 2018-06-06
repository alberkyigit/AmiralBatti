
public class ControllProcess {
	 public static boolean ShipPlaceControll(String[][] grid,int yIsAxis, int yAxis, int xAxis, int shipSize) {
		 if(yIsAxis == 0) {
			 for(int i = yAxis; i < yAxis + shipSize; i++)
			 {
				 if(!grid[i][xAxis].equals("."))
				 {
					 return false;
				 }
			 }
			 
		 }
		 else {
			 for(int j = xAxis; j < xAxis + shipSize; j++)
			 {
				 if(!grid[yAxis][j].equals("."))
				 {
					 return false;
				 }
			 }
		 }
		 
		 return true;
	 }
	 
	 public static boolean GunControll(int gunType) {
		 if(gunType < 0 || gunType > 2) {
			 System.out.println("Gecersiz silah. Lutfen gecerli bir silah turu seciniz.\n");
			 return false;
		 }
		 else if(StartGame.guns[gunType] == 0) {
			 System.out.println("Secili silahin cephanesi kalmamistir.\n");
			 return false;
		 }
		 
		 return true;
	 }
	 
	 public static boolean PlaneControll(int plane) {
		 if(plane < 0 || plane > 1) {
			 System.out.println("Gecersiz duzlem. Lutfen gecerli bir duzlem seciniz.\n");
			 return false;
		 }
		 
		 return true;
	 }
	 
	 public static boolean CoordinateControll(int xAxin, int yAxin, int size) {
		 if(xAxin < 0 || xAxin > size - 1 || yAxin < 0 || yAxin > size - 1) {
			 System.out.println("Gecersiz koordinat. Lutfen gecerli bir koordinat seciniz.\n");
			 return false;
		 }
		 
		 return true;
	 }
	 
	 public static boolean GunsControll()
	 {
		if(StartGame.guns[0] == 0 && StartGame.guns[1] == 0 && StartGame.guns[2] == 0)
		{
			System.out.println("Oyun bitti. Tum cephaneniz tukendi.");
			return false;
		}
		 return true;
	 }

	 public static boolean FinishControll(StartGame gamer)
	 {
		 int sayac=0;
		 
		 for(int i = 0; i < gamer.grid.length; i++)
		 {
			
			 for(int j = 0; j < gamer.grid.length; j++)
			 {
				 if(gamer.grid[i][j].equals("S")) sayac++;
			 }			 
		 }
		 if(sayac==0)
		 {
			 System.out.println("Tebrikler, tum gemileri vurdunuz.");
			 
			 return true;
		 }
			 
		 return false;
	 }
}