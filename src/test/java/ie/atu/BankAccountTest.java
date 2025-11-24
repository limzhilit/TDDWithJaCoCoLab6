package ie.atu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

  BankAccount account;

  @BeforeEach
  void setup() {
    account = new BankAccount();
  }

  @Test
  void constructorInitialisation() {
    account = new BankAccount("ACC123456", "Paul", 100);
    assertEquals("ACC123456", account.getAccount());
    assertEquals("Paul", account.getName());
    assertEquals(100, account.getBalance());

  }

  @Test
  void constructorNegativeInisialisation() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> new BankAccount("ACC123456", "Paul", -100));
    assertEquals("Balance must be greater than 0", ex.getMessage());
  }

  @Test
   void addPositiveBalance() {
    double initialAmount = account.getBalance();
    account.deposit(100);
    assertEquals(initialAmount + 100, account.getBalance());
  }

  @Test
  void addNegativeBalance() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> account.deposit(-200));
    assertEquals("Balance must be greater than 0", ex.getMessage());
  }

  @Test
  void withdrawPositiveAmount() {
    account.setBalance(100);
    double initialAmount = account.getBalance();
    account.withdraw(50);
    assertEquals(initialAmount - 50, account.getBalance());
  }

  @Test
  void withdrawNegativeAmount() {
    Exception ex = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-200));
    assertEquals("Balance must be greater than 0", ex.getMessage());
  }

  @Test
  void withdrawExceedingAmount() {
    int balance = account.getBalance();
    Exception ex = assertThrows(IllegalArgumentException.class, () -> account.withdraw(balance + 1));
    assertEquals("Balance must be greater than 0", ex.getMessage());
  }

  @Test
  void testSetter() {
    account.setName("Alex");
    assertEquals("Alex", account.getName());
    account.setBalance(100);
    assertEquals(100, account.getBalance());
    account.setAccount("ACC122456");
    assertEquals("ACC122456", account.getAccount());
  }



}
