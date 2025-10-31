public class Date {
    private int month; // 1-12（月份）
    private int day; // 1-31（根據月份決定天數）
    private int year; // 任意年份

    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // 建構子：確認月份與日期在該年份中是否正確
    public Date(int month, int day, int year) {
        // 檢查月份是否在範圍內
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException(
                    "月份 (" + month + ") 必須在 1-12 之間");
        }

        // 檢查日期是否在該月份的範圍內
        if (day <= 0 ||
                (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException("日期 (" + day +
                    ") 超出該月份與年份的範圍");
        }

        // 若為 2 月 29 日則需檢查是否為閏年
        if (month == 2 && day == 29 && !(year % 400 == 0 ||
                (year % 4 == 0 && year % 100 != 0))) {
            throw new IllegalArgumentException("日期 (" + day +
                    ") 超出該月份與年份的範圍");
        }

        this.month = month;
        this.day = day;
        this.year = year;

        //System.out.printf("建立日期物件：%s%n", this);
    }

    // 回傳格式為「月/日/年」的字串
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }

}

