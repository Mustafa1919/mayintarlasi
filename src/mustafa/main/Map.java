package mustafa.main;

import java.util.Random;

public class Map extends Logic{
	
	public static int[][] table ;
	private int numberMine;
	Random rnd;
	
	public Map() {
		// TODO Auto-generated constructor stub
		rnd = new Random();
		resetTable();
		randomGenerateMine();
		randomArrangeMine();
		arrangeMine();

	}
	
	
	public void resetTable() {
		for(int i=0; i<table.length; i++) {
			for(int j=0; j<table[i].length; j++)
				table[i][j] = 0;
		}
	}
	
	
	/*
	 * Random olarak mayin uretir. Kac adet mayin olacak rastgele uretir.
	 */
	public void randomGenerateMine() {
		numberMine = 10 + rnd.nextInt(39);
	}
	
	
	/*
	 * Mayinlar icin haritada rastgele yerler uret
	 */
	public void randomArrangeMine() {
		int x,y;
		int counter = 0;
		while(counter < numberMine) {
			x = rnd.nextInt(9);
			y = rnd.nextInt(9);
			if(table[x][y] == 0) {
				table[x][y] = 11;
				counter++;
			}
		}
	}
	
	
	/*
	 * Konumun kac mayina temas ettigini hesaplar
	 */
	public int foundMineNumber(int x, int y) {
		int counter = 0;
		if((x-1) >= 0) {
			if((y-1) >= 0) {
				if(table[x-1][y-1] == 11)
					counter++;
			}
			if(table[x-1][y] == 11)
				counter++;
			if((y+1) < table.length) {
				if(table[x-1][y+1] == 11)
					counter++;
			}
		}
		if((y-1) >= 0) {
			if(table[x][y-1] == 11)
				counter++;
		}
		if((y+1) < table.length) {
			if(table[x][y+1] == 11)
				counter++;
		}
		if((x+1) < table.length) {
			if((y-1) >= 0) {
				if(table[x+1][y-1] == 11)
					counter++;
			}
			if(table[x+1][y] == 11)
				counter++;
			if((y+1) < table.length) {
				if(table[x+1][y+1] == 11)
					counter++;
			}
		}
		return counter;
	}
	
	
	/*
	 * haritada temas eden mayinlarin sayisini yerlestirir
	 */
	public void arrangeMine() {
		int counter;
		for(int i=0; i<table.length; i++) {
			for(int j=0; j<table[i].length; j++) {
				if(table[i][j] == 0) {
					counter = foundMineNumber(i, j);
					table[i][j] = counter;
				}
			}
		}
	}
	
	
	public int getNumberMine() {return numberMine;}
	
}
