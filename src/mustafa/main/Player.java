package mustafa.main;

import java.util.Scanner;

public class Player {

	
	public int makeMove(Scanner input) {
		int choose;
		System.out.println("Hamlenizi M harfinin yanindaki sayi kodlari olarak giriniz.");
		System.out.println("Lutfen hamlenizi giriniz...");
		choose = input.nextInt();
		return choose;
	}
}
