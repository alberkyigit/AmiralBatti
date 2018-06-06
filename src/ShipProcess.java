
public class ShipProcess {
	 public static void DifficultChange(StartGame gamer)
	 {
		 
	 }
	
	 public static void LevelChange(StartGame gamer)
	 {
		 if(gamer.getDifficult().equals("easy") && gamer.getLevel()==1)
		 {
			 gamer.setDifficult("normal");
			 gamer.setLevel(0);
		 }
		 else if(gamer.getDifficult().equals("normal") && gamer.getLevel()==2)
		 {
			 gamer.setDifficult("hard");
			 gamer.setLevel(0);
		 }
		 else {
			 gamer.setLevel(gamer.getLevel()+1);
		 }
	 }

	 public static void Fire(int[] FireInfo, StartGame gamer) {
		 	
		 if(FireInfo[0] == 0) {
			 int fireCount = 0;
				 for(int i = FireInfo[2] - 1; i < FireInfo[2] + 2; i++)
				 {
					 if(i < 0 || i > gamer.grid.length - 1) { 
						 continue; 
					 }
					 else
					 { 
						 if(gamer.grid[i][FireInfo[1]].equals("X")) 
						 {
							 continue;
						 }
						 else if(gamer.grid[i][FireInfo[1]].equals("S"))
						 {
							 gamer.grid[i][FireInfo[1]]="X"; fireCount++;
						 }
						 else {
							 
							 gamer.grid[i][FireInfo[1]]="-";
							
							 
						 }
					 }
				 }
				 for(int i=FireInfo[1]-1; i<FireInfo[1]+2;i++)
				 {
					 if(i<0||i>gamer.grid.length-1) { continue; }
					 else {
						 
						 if(gamer.grid[FireInfo[2]][i].equals("X")) 
						 {
							 continue;
						 }
						 else if(gamer.grid[FireInfo[2]][i].equals("S"))
						 {
							 gamer.grid[FireInfo[2]][i]="X"; fireCount++;
						 }
						 else {
							 
							 gamer.grid[FireInfo[2]][i]="-";
							 
						 }
					 }
				 }
				 
				 if(fireCount==0) System.out.println("Bos atis yaptiniz.\n");
				 
			 
			 
			 StartGame.guns[0]--;
		 }else if(FireInfo[0]==1) {//Hand Bomb
			 
			
			 if(FireInfo[3]==0){//dikey
				 
				 int atisSayaci=0;
				 for(int i=FireInfo[2]-1; i<FireInfo[2]+2;i++)
				 {
					 if(i<0||i>gamer.grid.length-1) {atisSayaci++; continue; }
					 else {
						 
						 if(gamer.grid[i][FireInfo[1]].equals("X")) 
						 {
							 atisSayaci++;
						 }
						 else if(gamer.grid[i][FireInfo[1]].equals("S"))
						 {
							 gamer.grid[i][FireInfo[1]]="X";
						 } 
						 else {
							 
							 gamer.grid[i][FireInfo[1]]="-";
							 atisSayaci++;
							 
						 }
					 }
				 }
				 if(atisSayaci==3) System.out.println("Bos atis yaptiniz.\n");
				 
			 }else {//yatay
				 int atisSayaci=0;
				 for(int i=FireInfo[1]-1; i<FireInfo[1]+2;i++)
				 {
					 if(i<0||i>gamer.grid.length-1) {atisSayaci++; continue; }
					 else {
						 
						 if(gamer.grid[FireInfo[2]][i].equals("X")) 
						 {
							 atisSayaci++;
						 }
						 else if(gamer.grid[FireInfo[2]][i].equals("S"))
						 {
							 gamer.grid[FireInfo[2]][i]="X";
						 }
						 else {
							 
							 gamer.grid[FireInfo[2]][i]="-";
							 atisSayaci++;
						 }
					 }
				 }
				 if(atisSayaci==3) System.out.println("Bos atis yaptiniz.\n");
			 }
			 
			 StartGame.guns[1]--;
		 }else {// Gun Shot
			 if(gamer.grid[FireInfo[2]][FireInfo[1]].equals("X")) 
			 {
				 System.out.println("Vurulmus yeri tekrar vurdunuz.\n");
			 }
			 else if(gamer.grid[FireInfo[2]][FireInfo[1]].equals("S"))
			 {
				 gamer.grid[FireInfo[2]][FireInfo[1]]="X";
			 }
			 else {
				 
				 gamer.grid[FireInfo[2]][FireInfo[1]]="-";
				 System.out.println("Bos atis yaptiniz.\n");
			 }
			 StartGame.guns[2]--;
		 }
		 GridProcess.WriteGrid(gamer.grid);
	 }
	 
}
