import java.util.Scanner;
public class Code3_BankAccountTransactionSystem {
    private Account account;
    private Transaction transaction;
    public static void main(String[] args) {
        Code3_BankAccountTransactionSystem bankAccountSystem = new Code3_BankAccountTransactionSystem();
        bankAccountSystem.menu();
    }
    void menu() {
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("\nBANK ACCOUNT SYSTEM: -");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Balance");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = input.nextDouble();
                        transaction.deposit(depositAmount);
                    } else {
                        System.out.println("No account found. Create an account first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = input.nextDouble();
                        transaction.withdraw(withdrawAmount);
                    } else {
                        System.out.println("No account found. Create an account first.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        System.out.println("Account Holder: " + account.getAccountName());
                        System.out.println("Account Number: " + account.getAccountNumber());
                        System.out.println("Balance: " + account.getBalance());
                    } else {
                        System.out.println("No account found.");
                    }
                    break;
                case 0:
                    System.out.println("Thank You!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }
    void createAccount() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        String name = input.nextLine();
        System.out.print("Account Number: ");
        int accountNo = input.nextInt();
        System.out.print("Initial Deposit Amount: ");
        double amount = input.nextDouble();
        account = new Account(accountNo, name, amount);
        transaction = new Transaction(account);
        System.out.println("Account created successfully!");
    }
}
class Account {
    private int accountNumber;
    private String accountName;
    private double balance;
    Account(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }
    int getAccountNumber() {
        return accountNumber;
    }
    String getAccountName() {
        return accountName;
    }
    double getBalance() {
        return balance;
    }
    void setBalance(double balance) {
        this.balance = balance;
    }
}
class Transaction {
    private Account account;
    Transaction(Account account) {
        this.account = account;
    }
    void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposited " + amount + " successfully!");
    }
    void withdraw(double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawn " + amount + " successfully!");
        } else {
            System.out.println("Insufficient Balance! Available: " + account.getBalance());
        }
    }
}
/*Output: -
BANK ACCOUNT SYSTEM: -
1. Create Account
2. Deposit
3. Withdraw
4. Show Balance
0. Exit
Your choice: 1
Enter Your Name: Rounak Saha
Account Number: 12345678
Initial Deposit Amount: 10000
Account created successfully!

BANK ACCOUNT SYSTEM: -
1. Create Account
2. Deposit
3. Withdraw
4. Show Balance
0. Exit
Your choice: 2
Enter amount to deposit: 5000
Deposited 5000.0 successfully!

BANK ACCOUNT SYSTEM: -
1. Create Account
2. Deposit
3. Withdraw
4. Show Balance
0. Exit
Your choice: 4
Account Holder: Rounak Saha
Account Number: 12345678
Balance: 15000.0

BANK ACCOUNT SYSTEM: -
1. Create Account
2. Deposit
3. Withdraw
4. Show Balance
0. Exit
Your choice: 3
Enter amount to withdraw: 1000
Withdrawn 1000.0 successfully!

BANK ACCOUNT SYSTEM: -
1. Create Account
2. Deposit
3. Withdraw
4. Show Balance
0. Exit
Your choice: 4
Account Holder: Rounak Saha
Account Number: 12345678
Balance: 14000.0

BANK ACCOUNT SYSTEM: -
1. Create Account
2. Deposit
3. Withdraw
4. Show Balance
0. Exit
Your choice: 0
Thank You!
 */