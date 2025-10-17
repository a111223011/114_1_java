public class AccountTest {
    public static void main(String[] args) {
        // 建立帳戶並示範存款與提款
        Account acc1 = new Account("A123", "Alice", 1000.0);
        System.out.println(acc1);

        acc1.deposit(500.0);   // 正常存款
        acc1.withdraw(200.0);  // 正常提款
        acc1.withdraw(2000.0); // 餘額不足
        acc1.deposit(-50.0);   // 非法存款

        System.out.println(acc1);

        // 另一個帳戶示範
        Account acc2 = new Account("B456", "Bob", 0.0);
        acc2.withdraw(10.0); // 嘗試從空帳戶提款
        acc2.deposit(150.0);
        System.out.println(acc2);

        // 使用無參數建構子
        Account acc3 = new Account();
        System.out.println("acc3: " + acc3.getAccountNumber() + ", " + acc3.getAccountHolderName() + ", balance=" + acc3.getBalance());

        // 使用雙參數建構子
        Account acc4 = new Account("C789", "Carol");
        acc4.deposit(50.0);
        System.out.println("acc4: " + acc4.getAccountNumber() + ", " + acc4.getAccountHolderName() + ", balance=" + acc4.getBalance());

        // 顯示目前客戶數量與所有帳戶
        System.out.println("Customer count: " + Account.getCustomerCount());
        Account[] all = Account.getAccountsArray();
        System.out.println("All accounts:");
        for (Account a : all) {
            System.out.println(a);
        }
    }
}
