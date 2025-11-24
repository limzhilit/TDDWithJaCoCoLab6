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

}
