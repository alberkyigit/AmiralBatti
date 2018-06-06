import java.io.IOException;
import java.util.Scanner;

public class StartGame {
	private String name;
	private String difficult;
	private int level;
	public static Scanner scan = new Scanner(System.in);
	public static int[] guns;
	public static int arraysize;
	public  String [][] grid;
	
	public StartGame() {
		
	}
	public StartGame(String isim) {
		super();
		this.name = isim;
	}
	
	 public String getName() {
		return name;
	}

	public void setName(String isim) {
		this.name = isim;
	}
	public String getDifficult() {
		return difficult;
	}
	public void setDifficult(String zorluk) {
		this.difficult = zorluk;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public static void main(String[] args)throws IOException {
		FileControll.fileControllProcess();
		Menu.WriteMenu();
	 }
}
