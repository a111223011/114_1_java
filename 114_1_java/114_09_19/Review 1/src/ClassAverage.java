import java.util.Scanner;

public class ClassAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = 0;          // 成績總和
        int gradeCounter = 0;   // 成績數量

        System.out.println("請輸入成績，完成後請按 Ctrl+Z (Windows) 或 Ctrl+D (Mac/Linux) 結束：");

        // 只要還有輸入就持續讀取
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                int grade = input.nextInt();
                total += grade;
                gradeCounter++;
            } else {
                System.out.println("輸入錯誤，請輸入整數成績。");
                input.next(); // 跳過錯誤輸入
            }
        }

        // 計算並輸出結果
        if (gradeCounter > 0) {
            double average = (double) total / gradeCounter;
            System.out.printf("總分: %d\n", total);
            System.out.printf("成績數: %d\n", gradeCounter);
            System.out.printf("平均: %.2f\n", average);
        } else {
            System.out.println("沒有輸入成績");
        }
    }
}
