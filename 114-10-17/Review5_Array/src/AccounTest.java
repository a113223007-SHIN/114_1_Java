public class AccounTest {

    private int customerCount; //客戶量
    public static void main(String[] args) {

        Account account1 = new Account("A123", 1000.0, "TWD", "小明");
        Account account2 = new Account("B98", 500.0, "TWD", "小華");
        Account account3 = new Account("000000", 200.0, "TWD", "小美");

        // 顯示初始資料
        System.out.printf("持有人: %s 帳戶號碼: %s 初始餘額: %.2f %s%n",
                account1.getOwner(), account1.getAccountNumber(), account1.getBalance(), account1.getBaseCurrency());
        System.out.printf("持有人: %s 帳戶號碼: %s 初始餘額: %.2f %s%n",
                account2.getOwner(), account2.getAccountNumber(), account2.getBalance(), account2.getBaseCurrency());
        System.out.printf("持有人: %s 帳戶號碼: %s 初始餘額: %.2f %s%n%n",
                account3.getOwner(), account3.getAccountNumber(), account3.getBalance(), account3.getBaseCurrency());

        // 單筆存款
        account1.deposit(500.0);
        System.out.printf("持有人: %s 帳戶號碼: %s 存款後餘額: %.2f %s%n%n",
                account1.getOwner(), account1.getAccountNumber(), account1.getBalance(), account1.getBaseCurrency());

        // 多筆存款
        try {
            account2.deposit(1000.0, 2000.0);
            System.out.printf("持有人: %s 帳戶號碼: %s 多筆存款後餘額: %.2f %s%n%n",
                    account2.getOwner(), account2.getAccountNumber(), account2.getBalance(), account2.getBaseCurrency());
        } catch (IllegalArgumentException e) {
            System.out.println("存款錯誤: " + e.getMessage());
        }

        // 測試多幣別存款
        System.out.println("=== 測試多幣別存款 ===");
        try {
            account1.deposit(100, "usd");
            account1.deposit(5000, "jpy");
            account1.deposit(10, "eur");
            System.out.printf("持有人: %s 帳戶號碼: %s 存入多幣別後餘額: %.2f %s%n",
                    account1.getOwner(), account1.getAccountNumber(), account1.getBalance(), account1.getBaseCurrency());
        } catch (IllegalArgumentException e) {
            System.out.println("存款錯誤: " + e.getMessage());
        }
    }
}

