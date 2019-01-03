package mustafa.main;

public class Logic {
	
	
	public Logic() {
		// TODO Auto-generated constructor stub
		Map.table = new int[9][9];
	}

	
	public boolean ifLossGame(int x, int y) {
		if(Map.table[x][y] == 11) {
			System.out.println("Malesef mayina basarak oyunu kaybettiniz...");
			return true;
		}
		return false;		
	}
	
	
	public int choosingLoc(int x, int y) {
		return Map.table[x][y];
	}
	
	
	public boolean ifFinishGame(int round) {
		if(round == 81) {
			System.out.println("Tebrikler Oyunu Kazandiniz...");
			return false;
		}
		return true;
	}
	
	
	
}
