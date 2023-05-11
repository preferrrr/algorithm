import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] list = new int[301];

        for (int i = 1; i <= n; i++) {
            list[i] = scanner.nextInt();
        }

        //n번째 계단을 밟는 경우
        //n-3번째 계단을 밟고 오는 경우 중 최대 + n-1 계단 밟고, n 계단
        //n-2번째 계단을 밟고 오는 경우 중 최대 + n번 계단

        int[] score = new int[301];

        score[1] = list[1];
        score[2] = list[1] + list[2];
        score[3] = Math.max(list[1] + list[3], list[2] + list[3]);

        for (int i = 4; i <= n; i++) {
            score[i] = Math.max(score[i - 3] + list[i - 1], score[i - 2]) + list[i];
        }

        System.out.println(score[n]);
    }
}