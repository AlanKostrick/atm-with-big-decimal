import java.math.BigDecimal;

public class Atm {

	private BigDecimal currentBalance;
	private String pin;

	public BigDecimal getBalance() {
		return currentBalance;
	}

	private String getPin() {
		return pin;
	}

	public Atm(BigDecimal currentBalance, String pin) {
		this.currentBalance = currentBalance;
		this.pin = pin;
	}

	public void deposit(BigDecimal depositAmount) {
		currentBalance = currentBalance.add(depositAmount);
	}

	public void withdrawl(BigDecimal withdrawlAmount) {

		if (isAnIncompatibleWithdrawlValue(withdrawlAmount)) {
			currentBalance = currentBalance.subtract(new BigDecimal("0.00"));
		} else {
			currentBalance = currentBalance.subtract(withdrawlAmount);
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
	private boolean isAnIncompatibleWithdrawlValue(BigDecimal withdrawlAmount) {
		return withdrawlAmount.compareTo(this.getBalance()) > 0
				|| withdrawlAmount.remainder(new BigDecimal("10.00")).compareTo(BigDecimal.ZERO) != 0;
	}

}
