import java.util.Scanner;
class BankAccount{
    private double balance;
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount> 0){
            balance+=amount;
        }
    }
    public boolean withdraw(double amount){
        if(amount > 0 && amount<=balance){
            balance-=amount;
            return true;
        }
        return false;
    }
}
class ATM{
    private final BankAccount account;
    public ATM(BankAccount account){
        this.account = account;
    }
    public void displayMenu(){
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
    public void run(){
        boolean B = true;
        Scanner sc = new Scanner(System.in);
        while(B){
            System.out.println();
            displayMenu();
            System.out.println("Enter Your Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter the Amount to Withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    if(account.withdraw(withdrawAmount)){
                        System.out.println("Withdrawal Successful.");
                    }
                    else{
                        System.out.println("Insufficient Balance.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the Amount to Deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit Successful.");
                    break;
                case 3:
                    System.out.println("Your Account Balance is "+ account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank You for using the ATM.");
                B = false;
                    break;
                default:
                    System.out.println("Invalid Choice. Please try Again.");
                    break;
            }
        }
    }
}
public class Atm_Interface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
