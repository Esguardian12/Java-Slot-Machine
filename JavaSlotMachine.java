package fullCourse;
import java.util.Scanner;
import java.util.Random;

public class JavaSlotMachine {

	public static void main(String[] args) {
		
		//JAVA SLOT MACHINE
		Scanner stdio = new Scanner(System.in);
		int balance = 100;
		int bet;
		int payout;
		String[] row;
		String playAgain;
		
		System.out.println("*********************");
		System.out.println("Welcome to Java Slots");
		System.out.println("Symbols: 🍒 🍉 🍋 🔔 ⭐");
		System.out.println("*********************");
		
		//Play IF Balance > 0
		while(balance > 0) {
			System.out.println("Current Balance: $" + balance);
			System.out.println("Place your bet amount: ");
			bet = stdio.nextInt();
			stdio.nextLine();
			
		//Enter Bet Amount
		    if(bet > balance) {
		    	System.out.println("INSUFFICIENT FUNDS");
		    	continue;
		    }
		    else if(bet <= 0){
		    	System.out.println("Bet must be greater than 0");
		    }
		    else {
		    	balance -= bet;
		    }
			System.out.println("Spinning...");
			row = spinRow();
			printRow(row);
			payout = getPayout(row, bet);
			
			if(payout > 0) {
				System.out.println("You won $" + payout);
				balance += payout;
			}
			else {
				System.out.println("Sorry you lost this round");
			}
			
			System.out.println("Do you want to play again?: ");
			playAgain = stdio.nextLine().toUpperCase();
			
			if(!playAgain.equals("Y")) {
				break;
			}
		}
		
		System.out.println("GAME OVER! Your final balance is $" + balance );
		
        stdio.close();
	}
	
	static String[] spinRow() {
		
		String[] symbols = {"🍒", "🍉", "🍋", "🔔", "⭐"};
		String[] row = new String[3];
		Random random = new Random();
		
		
		for(int i = 0; i < 3; i++) {
			row[i] = symbols[random.nextInt(symbols.length)];
		}
		
		
		return row;
	}
	
	static void printRow(String[]row) {
		System.out.println("****************");
		System.out.println(" " + String.join(" | ", row));
		System.out.println("****************");
	}
	
	static int getPayout(String[] row, int bet) {
		
		if(row[0].equals(row[1]) && row[1].equals(row[2])) {
			return switch(row[0]) {
			    case "🍒" -> bet * 3;
			    case "🍉" -> bet * 4;
			    case "🍋" -> bet * 5;
			    case "🔔" -> bet * 10;
			    case "⭐" -> bet * 20;
			    default -> 0;
			};
		}
		else if(row[1].equals(row[2])) {
			return switch(row[0]) {
			    case "🍒" -> bet * 2;
			    case "🍉" -> bet * 3;
			    case "🍋" -> bet * 4;
			    case "🔔" -> bet * 5;
			    case "⭐" -> bet * 10;
			    default -> 0;
			};
		}else if(row[2].equals(row[3])) {
			return switch(row[0]) {
		    case "🍒" -> bet * 2;
		    case "🍉" -> bet * 3;
		    case "🍋" -> bet * 4;
		    case "🔔" -> bet * 5;
		    case "⭐" -> bet * 10;
		    default -> 0;
		};
	}
		
		return 0;
	}

}
