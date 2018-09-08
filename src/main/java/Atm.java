import java.math.BigDecimal;

public class Atm {

	private Money currentBalance;
	private String pin;

	public Money getBalance() {
		return currentBalance;
	}

	private String getPin() {
		return pin;
	}

	public Atm(Money currentBalance, String pin) {
		this.currentBalance = currentBalance;
		this.pin = pin;
	}

	public void deposit(Money depositAmount) {
		currentBalance.add(depositAmount);
	}

	public void withdrawl(Money withdrawlAmount) {

		if (isAnIncompatibleWithdrawlValue(withdrawlAmount)) {
			currentBalance.subtract(new Money(new BigDecimal("0.00")));
		} else {
			currentBalance.subtract(withdrawlAmount);
		}
	}

	public boolean allowAccess(String userEnteredPin) {
		if (userEnteredPin.equals(this.getPin())) {
			return true;
		} else {
			return false;
		}

	}

	// private methods known as helpers
	private boolean isAnIncompatibleWithdrawlValue(Money withdrawlAmount) {
		return withdrawlAmount.getValue().compareTo(this.getBalance().getValue()) > 0
				|| withdrawlAmount.getValue().remainder(new BigDecimal("10.00")).compareTo(BigDecimal.ZERO) != 0;
	}

}
