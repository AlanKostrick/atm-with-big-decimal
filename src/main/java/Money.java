import java.math.BigDecimal;

public class Money {

	private BigDecimal value;

	public BigDecimal getValue() {
		return value;
	}

	public Money(BigDecimal value) {
		this.value = value;
	}

	public void add(Money amountToAdd) {
		value = value.add(amountToAdd.getValue());
	}

	public void subtract(Money amountToSubtract) {
		value = value.subtract(amountToSubtract.getValue());
	}

	@Override
	public String toString() {
		return "Money [value=" + value + "]";
	}

}
