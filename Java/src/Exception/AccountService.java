package Exception;

public class AccountService {

	private double balance;

	public void withdraw(double value) throws InsufficientFundsException {
		if (value <= 0)
			throw new InsufficientFundsException();
	}
}
