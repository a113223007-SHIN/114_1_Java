// 檔案路徑: c:\Users\m306\Desktop\114_1_Java\114-10-31\CompositionDemo\src\AccountTest.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        List<Account> customers = new ArrayList<>(); // 儲存客戶帳戶的清單
        Account acc1 = new Account("A001", "Alice", "A12345678", 5000);
        addCustomer(customers, acc1);
        Account acc2 = new Account("A002", "Bob", "A33334444", 3000);
        addCustomer(customers, acc2);
        Account acc3 = new Account("A003", "Charlie","B44448888", -100);
        addCustomer(customers,  acc3);

        operation(customers);
        // 顯示所有客戶帳戶資訊
//        System.out.println("\n所有位客戶帳戶資訊:");
//        printCustomerAccounts(customers);
    }

    public static void operation(List<Account> customers) {
        Scanner scanner = new Scanner(System.in);
        Account selectedAccount;
        while (true) {
            menu();
            System.out.print("請選擇功能(1-7): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除換行符號
            switch (choice) {
                case 1:
                    System.out.print("輸入帳戶號碼: ");
                    String accNum = scanner.nextLine();
                    System.out.print("輸入持有人姓名: ");
                    String ownerName = scanner.nextLine();
                    System.out.print("輸入身分證字號: ");
                    String idNumber = scanner.nextLine();
                    System.out.print("輸入初始餘額: ");
                    double initialBalance;
                    try {
                        initialBalance = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("輸入金額格式錯誤，設為0");
                        initialBalance = 0;
                    }
                    Account newAccount = new Account(accNum, ownerName, idNumber, initialBalance);
                    addCustomer(customers, newAccount);
                    break;
                case 2:
                    System.out.print("輸入要查詢的帳戶號碼: ");
                    String searchAccNum = scanner.nextLine();
                    selectedAccount = customerInAction(customers, searchAccNum);
                    printCustomerInfo(selectedAccount);
                    break;

                case 3:
                    System.out.println("\n所有位客戶帳戶資訊:");
                    printCustomerAccounts(customers);
                    break;
                case 4:
                    System.out.print("輸入要刪除的帳戶號碼: ");
                    String deleteAccNum = scanner.nextLine();
                    deleteCustomer(customers, deleteAccNum);
                    break;
                case 5:
                    System.out.print("輸入要存款的帳戶號碼: ");
                    String depAccNum = scanner.nextLine();
                    Account depAcc = customerInAction(customers, depAccNum);
                    if (depAcc != null) {
                        System.out.print("輸入存款金額: ");
                        double depAmount;
                        try {
                            depAmount = Double.parseDouble(scanner.nextLine());
                            depAcc.deposit(depAmount);
                            System.out.println("存款成功，當前餘額: " + depAcc.getBalance());
                        } catch (NumberFormatException e) {
                            System.out.println("金額格式錯誤");
                        } catch (IllegalArgumentException e) {
                            System.out.println("存款失敗: " + e.getMessage());
                        }
                    }
                    break;
                case 6:
                    System.out.print("輸入要提款的帳戶號碼: ");
                    String wthAccNum = scanner.nextLine();
                    Account wthAcc = customerInAction(customers, wthAccNum);
                    if (wthAcc != null) {
                        System.out.print("輸入提款金額: ");
                        double wthAmount;
                        try {
                            wthAmount = Double.parseDouble(scanner.nextLine());
                            wthAcc.withdraw(wthAmount);
                            System.out.println("提款成功，當前餘額: " + wthAcc.getBalance());
                        } catch (NumberFormatException e) {
                            System.out.println("金額格式錯誤");
                        } catch (IllegalArgumentException e) {
                            System.out.println("提款失敗: " + e.getMessage());
                        }
                    }
                    break;
                case 7:
                    System.out.println("離開系統，謝謝使用!");
                    return;
                default:
                    System.out.println("無效的選擇，請重新輸入");
            }
        }
    }

    public static Account customerInAction(List<Account> customers, String accountNumber) {
        for (Account account : customers) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("找不到指定的帳戶號碼: " + accountNumber);
        return null;
    }

    public static void addCustomer(List<Account> customers, Account newAccount) {
        customers.add(newAccount);
        System.out.println("新增客戶成功: " + newAccount.getAccountNumber());
    }

    public static void deleteCustomer(List<Account> customers, String accountNumber) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getAccountNumber().equals(accountNumber)) {
                Account removedAccount = customers.remove(i);
                System.out.println("刪除客戶成功: " + removedAccount.getAccountNumber() + " (" + removedAccount.getOwnerName() + ")");
                return;
            }
        }
        System.out.println("找不到指定的帳戶號碼: " + accountNumber);
    }

    public static void printCustomerAccounts(List<Account> customers) {
        for (Account customer : customers) {
            printCustomerInfo(customer);
        }
    }

    public static void printCustomerInfo(Account account) {
        if (account == null) {
            System.out.println("無法列印帳戶資訊，帳戶不存在");
            return;
        }
        System.out.println(account);
    }

    // 功能選單 (1) 新增客戶 (2) 列印指定客戶帳戶資訊 (3) 顯示所有客戶帳戶資訊 (4) 刪除客戶帳戶 (5) 存款 (6) 提款 (7) 離開
    public static void menu() {
        System.out.println("功能選單:");
        System.out.println("1. 新增客戶");
        System.out.println("2. 列印指定客戶帳戶資訊");
        System.out.println("3. 顯示所有客戶帳戶資訊");
        System.out.println("4. 刪除客戶帳戶");
        System.out.println("5. 存款");
        System.out.println("6. 提款");
        System.out.println("7. 離開");
    }
}
