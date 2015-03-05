import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AccountTestPS3 {

	Account TestAccount;


	@Before
	public void setUp() throws Exception {
		TestAccount = new Account(1112,20000);
	}

	@After
	public void tearDown() throws Exception {
		TestAccount = null;
	}
	
	
	
	@Test
	public final void Accounttest() throws InsufficientFundsException  {
		double TestResult=0;
		double MonthlyInterestResult=0;
		TestAccount.setAnnualInterestRate(.045);
		TestAccount.withdraw(2500);
		TestResult=TestAccount.deposit(3000);
		MonthlyInterestResult = TestAccount.getMonthlyInterestRate();
		System.out.printf("The balance of the account is $%,.2f.\n", TestAccount.getBalance());
		System.out.println("The monthly interest of the account is "+(TestAccount.getMonthlyInterestRate()*100)+"%");
		System.out.println("The account was created on "+ TestAccount.getDateCreated());
		//check that the amount withdrawn is what it is supposed to be
		assertEquals(20500,TestResult,0);
		assertEquals(.00375,MonthlyInterestResult, .001);
	}
	@Test 
	public final void Withdrawtest() throws InsufficientFundsException{
		boolean overdrawn = false;
		try {
			TestAccount.withdraw(40000);}
		catch (InsufficientFundsException e) {overdrawn=true;}
		assertEquals (overdrawn, true);
	}
}
