import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class AtmTest {

	Money initialBal = new Money(new BigDecimal("50.00"));
	Atm underTest = new Atm(initialBal, "1234");

	@Test
	public void shouldIncreaseBalanceFrom50To100WithDeposit() {
		underTest.deposit(new Money(new BigDecimal("50.00")));
		BigDecimal check = underTest.getBalance().getValue();
		assertThat(check, is(new BigDecimal("100.00")));
	}

	@Test
	public void shouldDecreaseBalanceFrom50To30WithWithdrawl() {
		underTest.withdrawl(new Money(new BigDecimal("20.00")));
		BigDecimal check = underTest.getBalance().getValue();
		assertThat(check, is(new BigDecimal("30.00")));
	}

	@Test
	public void shouldReturnBalanceOf50WithWithdrawlOf60() {
		underTest.withdrawl(new Money(new BigDecimal("60.00")));
		BigDecimal check = underTest.getBalance().getValue();
		assertThat(check, is(new BigDecimal("50.00")));
	}

	@Test
	public void shouldReturnBalanceOf50WithWithdrawlOf45() {
		underTest.withdrawl(new Money(new BigDecimal("45.00")));
		BigDecimal check = underTest.getBalance().getValue();
		assertThat(check, is(new BigDecimal("50.00")));
	}

	@Test
	public void shouldAllowAccessWithCorrectPin() {
		boolean allow = underTest.allowAccess("1234");
		assertTrue(allow);
	}

	@Test
	public void shouldDenyAccessWithInCorrectPin() {
		boolean allow = underTest.allowAccess("4321");
		assertFalse(allow);
	}

}
