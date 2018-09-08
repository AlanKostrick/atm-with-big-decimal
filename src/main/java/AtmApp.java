import java.math.BigDecimal;
import java.util.Scanner;

public class AtmApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Atm myAtm = new Atm(new BigDecimal("500.00"), "1234");

		System.out.println("Please enter your PIN");
		String userEnteredPin = input.nextLine();

		while (myAtm.allowAccess(userEnteredPin) == false) {
			System.out.println("Incorrect password");
			System.out.println("Please enter your PIN");
			userEnteredPin = input.nextLine();
		}

		System.out.println("Welcome!");

		String userChoice;

		do {
			System.out.println("Press 1 to deposit");
			System.out.println("Press 2 to withdrawl");
			System.out.println("Press 3 to check balance");
			System.out.println("Press 4 to exit");
			userChoice = input.nextLine();

			if (userChoice.equals("1")) {
				System.out.println("How much do you want to deposit:");
				BigDecimal depositAmount = input.nextBigDecimal();
				myAtm.deposit(depositAmount);
				input.nextLine();
			} else if (userChoice.equals("2")) {
				System.out.println("How much do you want to withdrawl");
				BigDecimal withdrawlAmount = input.nextBigDecimal();
				myAtm.withdrawl(withdrawlAmount);
				input.nextLine();
			} else if (userChoice.equals("3")) {
				System.out.println("You balance is: " + myAtm.getBalance());
			} else if (userChoice.equals("4")) {
				System.out.println("Thanks for banking with us!");
				System.exit(0);
			} else {
				System.out.println("I'm sorry I don't understand your request.");
			}

		} while (!userChoice.equals("4"));

		System.out.println("Thanks for using our ATM Have a nice day!");
		input.close();
	}

}
