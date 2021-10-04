package view;

import java.util.Scanner;

public class Debug {

	Scanner scan;
	Data data;
	
	public Debug() {
		scan = new Scanner(System.in);
		data = new Data();
	}
	
	void screen() {
		clear();
		System.out.println(" ________________________");
		System.out.println("|                        |");
		System.out.println("|       Debug Menu       |");
		System.out.println("|________________________|  Created by: TheAssortedThree\n");
		
		System.out.println("\nWhat data set would you like to switch to?");
		System.out.println("(1) Pending jobs are maxed");
		System.out.println("(2) Pending job in a week are maxed");
		System.out.println("(3) Work Category is maxed");
		System.out.println("(4) Default");
		int ans = scan.nextInt();
		switch (ans) {
		case 1:
			data.ruleMax30();
			break;
		case 2:
			data.ruleMax5();
			break;
		case 3:
			data.ruleMaxWorkCategory();
			break;
		case 4:
			data.freshData();
			break;
		}
	}
	
	void clear() {
		for (int i = 0; i < 10; i++) {
			System.out.println("\n\n\n\n\n");
		}
	}
	
	void ProductionMenu() {
		clear();
		System.out.println(" ________________________");
		System.out.println("|                        |");
		System.out.println("|    Production Menu     |");
		System.out.println("|________________________|  Created by: TheAssortedThree\n");
	}
}
