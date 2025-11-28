// Account 類別：代表銀行帳戶
public class Account {
    // 帳戶號碼
    private String accountNumber;
    // 帳戶持有人姓名
    private String accountHolderName;
    // 帳戶餘額
    private double balance;

    // 建構子：初始化帳戶號碼、持有人姓名及初始餘額
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber; // 設定帳戶號碼
        this.accountHolderName = accountHolderName; // 設定持有人姓名
        this.balance = initialBalance; // 設定初始餘額
    }

    // 取得帳戶號碼
    public String getAccountNumber() {
        return accountNumber;
    }

    // 取得帳戶持有人姓名
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // 取得帳戶餘額
    public double getBalance() {
        return balance;
    }

    // 存款方法：將金額存入帳戶
    public void deposit(double amount) {
        if (amount > 0) { // 檢查存款金額是否為正數
            balance += amount; // 增加餘額
            System.out.println("Deposited: " + amount); // 顯示存款訊息
        } else {
            System.out.println("Deposit amount must be positive."); // 存款金額必須為正
        }
    }

    // 提款方法：從帳戶提取金額
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) { // 檢查提款金額是否合理
            balance -= amount; // 減少餘額
            System.out.println("Withdrew: " + amount); // 顯示提款訊息
        } else if (amount > balance) { // 檢查是否餘額不足
            System.out.println("Insufficient funds."); // 顯示餘額不足訊息
        } else {
            System.out.println("Withdrawal amount must be positive."); // 提款金額必須為正
        }
    }

    // toString 方法：回傳帳戶資訊字串
    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
