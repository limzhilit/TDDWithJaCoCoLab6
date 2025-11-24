package ie.atu;

public class BankAccount {

  String account;
  String name;
  int balance;

  public BankAccount(String account, String name, int balance) {
    if(balance < 0) {
      throw new IllegalArgumentException("Balance must be greater than 0");
    }
    this.account = account;
    this.name = name;
    this.balance = balance;
  }

  public BankAccount() {

  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void deposit(int amount) {
    if(amount <= 0 ) {
      throw new IllegalArgumentException("Balance must be greater than 0");
    }
    setBalance(getBalance() + amount);
  }

  public void withdraw(int amount) {
    if(amount <= 0 || amount > balance) {
      throw new IllegalArgumentException("Balance must be greater than 0");
    }
    setBalance(getBalance() - amount);
  }
}
