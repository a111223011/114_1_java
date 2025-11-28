import java.util.Scanner;

public class Account {
    // 帳戶號碼，唯一識別每個帳戶
    private String accountNumber;
    // 帳戶餘額，儲存目前帳戶的金額
    private double balance;

    /**
     * 建構子：初始化帳戶號碼與初始餘額
     * @param accountNumber 帳戶號碼
     * @param initialBalance 初始餘額
     */
    public Account(String accountNumber, double initialBalance) {
        this.setAccountNumber(accountNumber);
        try {
            this.setBalance(initialBalance); // 設定初始餘額
        } catch (IllegalArgumentException e) {
            System.out.println("初始餘額錯誤: " + e.getMessage()+", 將初始餘額設為0");
        }
    }

    /**
     * 取得帳戶號碼
     * @return 帳戶號碼
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 取得帳戶餘額
     * @return 帳戶餘額
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 設定帳戶餘額
     * @param balance 新的帳戶餘額，必須大於0
     * @throws IllegalArgumentException 如果餘額小於等於0
     */
    public void setBalance(double balance) {
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);
        while (attempts < 3) {
            if (balance > 0) {
                this.balance = balance;
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.print("餘額必須為正數，請重新輸入：");
                    balance = scanner.nextDouble();
                }
            }
        }
        throw new IllegalArgumentException("餘額必須為正數，已超過三次機會！");
    }

    /**
     * 設定帳戶號碼
     * @param accountNumber 新的帳戶號碼
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * 存款方法：將指定金額存入帳戶
     * @param amount 存款金額，必須大於0
     * @throws IllegalArgumentException 如果存款金額小於等於0
     */
    public void deposit(double amount) {
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);
        while (attempts < 3) {
            if (amount > 0) {
                balance += amount;
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.print("存款金額必須為正數，請重新輸入：");
                    amount = scanner.nextDouble();
                }
            }
        }
        throw new IllegalArgumentException("存款金額必須為正數，已超過三次機會！");
    }

    /**
     * 多幣別存款方法，將金額依照幣別轉換成新台幣後存入帳戶
     * @param amount   欲存入的金額
     * @param currency 幣別（可為 "USD", "EUR", "JPY"）
     */
    public void deposit(double amount, String currency) {
        double exchangeRate = 1.0; // 預設匯率為1.0（假設台幣為基準）
        switch (currency.toUpperCase()) {
            case "USD":
                exchangeRate = 30.0; // 假設1 USD = 30 TWD
                break;
            case "EUR":
                exchangeRate = 35.0; // 假設1 EUR = 35 TWD
                break;
            case "JPY":
                exchangeRate = 0.25; // 假設1 JPY = 0.25 TWD
                break;
            default:
                System.out.println("未知的貨幣，使用預設匯率1.0。");
                return;
        }

        double amountInTWD = amount * exchangeRate; // 將外幣轉換為台幣
        this.deposit(amountInTWD); // 呼叫單一金額存款方法存入
    }

    /**
     * 多筆金額存款方法，將多筆金額累加後存入帳戶
     * @param amounts 可變參數形式的多筆金額
     */
    public void deposit(double... amounts) {
        double totalAmount = 0;
        for (double amount : amounts) {
            if (amount > 0) {
                totalAmount += amount;
            } else {
                throw new IllegalArgumentException("金額必須為正數！");
            }
        }
        this.deposit(totalAmount);
    }

    /**
     * 提款方法：從帳戶扣除指定金額
     * @param amount 提款金額，必須大於0且小於等於餘額
     * @throws IllegalArgumentException 如果提款金額不合法
     */
    public void withdraw(double amount) {
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);
        while (attempts < 3) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return;
            } else {
                attempts++;
                if (attempts < 3) {
                    System.out.print("提款金額不合法，請重新輸入：");
                    amount = scanner.nextDouble();
                }
            }
        }
        throw new IllegalArgumentException("提款金額不合法，已超過三次機會！");
    }
}
