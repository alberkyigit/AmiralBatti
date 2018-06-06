
public class GridProcess {

	 public static void FullGrid(String[][] grid) {
		 for(int i=0; i<grid.length;i++)
		 {
			 for(int j=0; j<grid.length;j++)
			 {
				 grid[i][j]=".";
			 }
		 }
	 }
	 
	 public static void CreateGrid(String[][] grid, String difficult) {
		 int[] gemiler;
		 if(difficult.equals("easy") ){
		 	gemiler = new int[] {1,1,1,0};
		 	StartGame.guns = new int[] {1,2,7};
		 	 
		 	ShipPlace(grid, gemiler);
		 	
		 }
		 else if(difficult.equals("normal") ){
			 gemiler = new int[] {2,1,1,1};
			 StartGame.guns = new int[] {1,3,10};
			 ShipPlace(grid, gemiler);
			
		 }
		 else {
			 gemiler = new int[] {2,1,1,1};
			 StartGame.guns = new int[] {1,4,12};
			 ShipPlace(grid, gemiler);
		 }
	 }
	 
	 public static final void WriteGrid(String[][] grid) {
		 if(grid.length == 10) {
			 System.out.println("   0  1  2  3  4  5  6  7  8  9");
		 }
		 else if(grid.length == 15) {
			 System.out.println("   0  1  2  3  4  5  6  7  8  9  10 11 12 13 14");
		 }
		 else{
			 System.out.println("   0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19");
		 }
		 
		 for(int i=0; i < grid.length; i++)
		 {
			 if(i<10) {
				 System.out.print(i + "  ");	 
			 }
			 else{
				 System.out.print(i + " ");
			 }
			 
			 for(int j = 0; j < grid.length; j++)
			 {
				 System.out.print(grid[i][j] + "  ");
			 }
			 
			 System.out.println("");
		 }
	 }

	 public static void ShipPlace(String[][] grid, int[] ships) {
		 FullGrid(grid);
		 int yAxis;
		 int xAxis;
		 int yIsAxis;
		 
		 for(int i=0; i<4;i++)
		 {
			 for(int j = 0; j < ships[i]; j++)
			 {
				 do {
					 yIsAxis = (int)(Math.random()*2);
					 
					 if(yIsAxis == 0)
					 {
						  yAxis = (int)(Math.random()*(grid.length-i));
						  xAxis = (int)(Math.random()*(grid.length));
					 }
					 else
					 {
						  xAxis = (int)(Math.random()*(grid.length-i));
						  yAxis = (int)(Math.random()*(grid.length));
					 }
					 
					 }
				 while(!ControllProcess.ShipPlaceControll(grid,yIsAxis, yAxis, xAxis, i + 1));
					 Place(grid,yIsAxis, yAxis, xAxis, i + 1);
			 }
		 }
	 }

	 public static void Place(String[][] grid, int yIsAxis, int yAxis, int xAxis, int shipSize) {		 
		 if(yIsAxis == 0) {
			 for(int i = yAxis; i < yAxis + shipSize; i++)
			 {
				 grid[i][xAxis] = "S";
			 }
		 }
		 else
		 {
			 for(int j = xAxis; j < xAxis + shipSize; j++)
			 {
				 grid[yAxis][j] = "S";
			 }
		 }
	 }
}
