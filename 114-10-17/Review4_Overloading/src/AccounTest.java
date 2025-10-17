public class AccounTest {
    public static void main(String[] args) {

        Account account1 = new Account("A123", 1000.0, "TWD");
        Account account2 = new Account("B98", 500.0, "TWD");
        Account account3 = new Account("000000", 200.0, "TWD"); // 初始餘額小於 0
        // 顯示初始資料
        System.out.printf("帳戶號碼: %s%n初始餘額: %.2f %s%n",
                account1.getAccountNumber(), account1.getBalance(), account1.getBaseCurrency());
        System.out.printf("帳戶號碼: %s%n初始餘額: %.2f %s%n%n",
                account2.getAccountNumber(), account2.getBalance(), account2.getBaseCurrency());
        System.out.printf("帳戶號碼: %s%n初始餘額: %.2f %s%n%n",
                account3.getAccountNumber(), account3.getBalance(), account3.getBaseCurrency());
        // 單筆存款
        account1.deposit(500.0);
        System.out.printf("帳戶號碼: %s%n存款後餘額: %.2f %s%n%n",
                account1.getAccountNumber(), account1.getBalance(), account1.getBaseCurrency());

        // 多筆存款（最多兩筆）
        try {
            account2.deposit(1000.0, 2000.0);
            System.out.printf("帳戶號碼: %s%n多筆存款後餘額: %.2f %s%n%n",
                    account2.getAccountNumber(), account2.getBalance(), account2.getBaseCurrency());
        } catch (IllegalArgumentException e) {
            System.out.println("存款錯誤: " + e.getMessage());
        }

        try {
            account3.deposit(200.0,400.0,300.0); // 超過兩筆存款
            System.out.printf("帳戶號碼: %s%n多筆存款後餘額: %.2f %s%n%n",
                    account3.getAccountNumber(), account3.getBalance(), account3.getBaseCurrency());
        } catch (IllegalArgumentException e) {
            System.out.println("存款錯誤: " + e.getMessage());
        }
        // 測試不同幣別存款
        System.out.println("=== 測試多幣別存款 ===");
        try {
            account1.deposit(100, "usd");
            account1.deposit(5000, "jpy");
            account1.deposit(10, "eur");
            System.out.printf("帳戶號碼: %s%n存入多幣別後餘額: %.2f %s%n",
                    account1.getAccountNumber(), account1.getBalance(), account1.getBaseCurrency());
        } catch (IllegalArgumentException e) {
            System.out.println("存款錯誤: " + e.getMessage());
        }
    }
}
