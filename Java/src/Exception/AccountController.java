package Exception;

public class AccountController {

	public static void show(double money) {
		AccountService service = new AccountService();
		try {
			service.withdraw(money);
			System.out.println("Money withdrawed");
		} catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		AccountController acc = new AccountController();
		acc.show(10);
	}
}
