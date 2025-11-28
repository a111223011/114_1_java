// 新增 import，以使用 ArrayList
import java.util.ArrayList;

// Account 類別：代表銀行帳戶
public class Account {
    // 靜態：所有帳戶的集合與客戶數量
    private static final ArrayList<Account> accounts = new ArrayList<>();
    // 靜態變數：客戶數量（方便直接存取）
    private static int customerCount = 0;
    // 靜態變數：帳戶物件陣列（快照）
    private static Account[] accountsArray = new Account[0];

    // 帳戶號碼
    private final String accountNumber;
    // 帳戶持有人姓名
    private final String accountHolderName;
    // 帳戶餘額
    private double balance;

    // 無參數建構子：建立預設帳戶
    public Account() {
        this("0000", "Unknown", 0.0);
    }

    // 雙參數建構子：不指定初始餘額，預設為 0.0
    public Account(String accountNumber, String accountHolderName) {
        this(accountNumber, accountHolderName, 0.0);
    }

    // 建構子：初始化帳戶號碼、持有人姓名及初始餘額
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber; // 設定帳戶號碼
        this.accountHolderName = accountHolderName; // 設定持有人姓名
        this.balance = initialBalance; // 設定初始餘額
        // 把新建立的帳戶加入靜態集合
        accounts.add(this);
        // 更新靜態變數
        customerCount = accounts.size();
        accountsArray = accounts.toArray(new Account[0]);
    }

    // 新增靜態方法：直接傳入 Account 實例來新增客戶
    public static void addAccount(Account account) {
        if (account == null) return;
        accounts.add(account);
        customerCount = accounts.size();
        accountsArray = accounts.toArray(new Account[0]);
    }

    // 新增靜態方法：以參數建立並新增新客戶（回傳建立的 Account）
    public static Account addCustomer(String accountNumber, String accountHolderName, double initialBalance) {
        Account acc = new Account(accountNumber, accountHolderName, initialBalance);
        // 因為上面建構子已加入 accounts，這裡不需再次加入。
        return acc;
    }

    // 取得目前客戶數量
    public static int getCustomerCount() {
        return customerCount;
    }

    // 取得帳戶陣列（複本）
    public static Account[] getAccountsArray() {
        return accountsArray.clone();
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
