package mustafa.main;

import java.util.Scanner;

public class MineField extends Map{
	
	private String[][] tempField;
	public Scanner input;
	private Player player;
	

	public MineField() {
		// TODO Auto-generated constructor stub
		tempField = new String[9][9];
		player = new Player();
		input = new Scanner(System.in);
		initField();
		printField();
		startGame();
		input.close();
	}
	
	
	private void initField() {
		int count = 1;
		for(int i=0; i<tempField.length; i++) {
			for(int j=0; j<tempField[i].length; j++) {
				tempField[i][j] = "M"+count;
				count++;
			}
		}
	}
	
	
	private void printField() {
		for(int i=0; i<tempField.length; i++) {
			for(int j=0; j<tempField[i].length; j++) {
				System.out.printf("%5S",tempField[i][j]);
			}
			System.out.println();
		}
		System.out.println("Mayin Sayisi : " + getNumberMine());
	}
	
	
	private void startGame() {
		int round = getNumberMine();
		int flag = getNumberMine();
		int x, y, temp;
		String move;
		while(ifFinishGame(round)) {
			move = player.makeMove(input);
			temp = Integer.parseInt(move.substring(1 , move.length()));
//			System.out.println(move.substring(0,1).toUpperCase());
//			System.out.println(temp);
			x = ((temp-1)/9);
			y = ((temp-1)%9);
			if(move.substring(0,1).toUpperCase().equals("M")) {
				if(ifLossGame(x, y)) {
					tempField[x][y] = "BOMM";
					finishTable();
					break;
				}
				if(tempField[x][y].toCharArray()[0] == 'M') {
					tempField[x][y] = String.valueOf(choosingLoc(x, y));
					printField();
					System.out.println("Kalan flag : " + flag);
					round++;
				}
				else
					System.out.println("Girilen konum daha once secilmis");
			}
			else if(move.substring(0, 1).toUpperCase().equals("F")) {
				if(tempField[x][y].substring(0, 1).equals("M")) {
					if(flag <= 0)
						System.out.println("Flag hakkiniz kalmadi");
					else {
						tempField[x][y] = "F"+temp;
						flag--;
					}
				}
				else if(tempField[x][y].substring(0, 1).equals("F")) {
					tempField[x][y] = "M"+temp;
					flag++;
				}
				else {
					System.out.println("Hatali bir girdi.");
				}
				printField();
				System.out.println("Kalan flag : " + flag);
			}
			else
				System.out.println("Hatali girdi...");
		}
	}
	
	
}
