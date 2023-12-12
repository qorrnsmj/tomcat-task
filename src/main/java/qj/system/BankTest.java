package qj.system;

public class BankTest {
    public static void main(String[] args) {
        int result;
        Bank bank = new Bank();
        bank.open("Alice");

        System.out.println("[預金テスト]");

        // 顧客が存在しない場合 -7
        result = bank.deposit("Bob", "1000");
        System.out.println(result == 0 ? "預金失敗で正常です" : "戻り値が" + result + "で誤りです");

        // 金額が不正な場合 -4
        result = bank.deposit("Alice", "一万");
        System.out.println(result == 0 ? "預金失敗で正常です" : "戻り値が" + result + "で誤りです");

        // 存在しない顧客かつ金額不正の場合 -7 && -4
        result = bank.deposit("Bob", "一万");
        System.out.println(result == 0 ? "預金失敗で正常です" : "戻り値が" + result + "で誤りです");

        // 正常 0
        result = bank.deposit("Alice", "1000");
        System.out.println(result == 0 ? "預金成功で正常です" : "戻り値が" + result + "で誤りです");
        System.out.println("残高" + bank.showBalance("Alice") + "円です");



        System.out.println("\n[引き出しテスト]");

        // 顧客が存在しない場合 -7
        result = bank.withdraw("Bob", "1000");
        System.out.println(result == 0 ? "引き出し失敗で正常です" : "戻り値が" + result + "で誤りです");

        // 金額が不正な場合 -4
        result = bank.withdraw("Alice", "一万");
        System.out.println(result == 0 ? "預金失敗で正常です" : "戻り値が" + result + "で誤りです");

        // 存在しない顧客かつ金額不正の場合 -7 && -4
        result = bank.withdraw("Bob", "一万");
        System.out.println(result == 0 ? "引き出し失敗で正常です" : "戻り値が" + result + "で誤りです");

        // 正常 0
        result = bank.withdraw("Alice", "500");
        System.out.println(result == 0 ? "引き出し成功で正常です" : "戻り値が" + result + "で誤りです");
        System.out.println("残高" + bank.showBalance("Alice") + "円です");
    }
}
