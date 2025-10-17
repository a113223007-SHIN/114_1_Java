import java.util.HashMap;
import java.util.Map;

public class Account {
    private String accountNumber;
    private double balance;
    private String baseCurrency; // 帳戶主要幣別
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // 匯率相對於台幣（假設）
        exchangeRates.put("TWD", 1.0);
        exchangeRates.put("USD", 32.5);   // 1 USD = 32.5 TWD
        exchangeRates.put("JPY", 0.22);   // 1 JPY = 0.22 TWD
        exchangeRates.put("EUR", 35.0);   // 1 EUR = 35.0 TWD
    }

    // 建構子
    public Account(String accountNumber, double balance) {
        this(accountNumber, balance, "TWD"); // 預設台幣
    }

    public Account(String accountNumber, double balance, String baseCurrency) {
        this.accountNumber = accountNumber;
        this.baseCurrency = baseCurrency.toUpperCase();

        if (balance < 0) {
            System.out.println("警告：初始餘額小於 0，已設為 0");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    // 單筆存款（預設帳戶幣別）
    public void deposit(double amount) {
        deposit(amount, baseCurrency);
    }

    // 存款（指定幣別）
    public void deposit(double amount, String currency) {
        if (amount <= 0) {
            throw new IllegalArgumentException("存款金額必須大於 0");
        }

        currency = currency.toUpperCase();
        if (!exchangeRates.containsKey(currency)) {
            throw new IllegalArgumentException("不支援的幣別：" + currency);
        }

        double rate = exchangeRates.get(currency);
        double amountInTWD = amount * rate;

        balance += amountInTWD;

        System.out.printf("成功存入 %.2f %s (折合 %.2f TWD)%n", amount, currency, amountInTWD);
    }

    // 多筆存款（最多 2 筆）
    public void deposit(double... amounts) {
        if (amounts.length == 0) {
            throw new IllegalArgumentException("請輸入存款金額");
        }
        if (amounts.length > 2) {
            throw new IllegalArgumentException("最多只能輸入兩筆存款金額");
        }
        for (double a : amounts) {
            if (a <= 0) {
                throw new IllegalArgumentException("每筆存款金額都必須大於 0");
            }
            balance += a;
        }
    }

    // 提款
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("提款金額必須大於 0");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("餘額不足");
        }
        balance -= amount;
    }

    // Getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }
}
