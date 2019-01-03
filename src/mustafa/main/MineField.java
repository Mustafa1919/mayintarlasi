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
	}
	
	
	private void startGame() {
		int round = getNumberMine();
		int move, x, y;
		while(ifFinishGame(round)) {
			move = player.makeMove(input);
			x = ((move-1)/9);
			y = ((move-1)%9);
			if(ifLossGame(x, y)) {
				tempField[x][y] = "BOM";
				printField();
				break;
			}
			if(tempField[x][y].toCharArray()[0] == 'M') {
				tempField[x][y] = String.valueOf(choosingLoc(x, y));
				printField();
				round++;
			}
			else
				System.out.println("Girilen konum daha once secilmis");
		}
	}
	
	
	
	
	
	
	
	
	
	
}
