package mustafa.main;

import java.util.Scanner;

public class Player {

	
	public String makeMove(Scanner input) {
		String choose;
		System.out.println("Hamlenizi basinda M olarak/Bayragi basinda F olarak giriniz.");
		System.out.println("Lutfen hamlenizi giriniz...");
		choose = input.next();
		return choose;
	}
}
