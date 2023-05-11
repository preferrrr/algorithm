import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] dp = new int[31][31];
        // dp[n][m] = dp[n-1][m-1] + dp[n][m-1]

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        int[] result = new int[T];
        for (int t = 0; t < T; t++) {

            int N = scanner.nextInt();
            int M = scanner.nextInt();

            for (int i = 1; i <= M; i++) {
                dp[1][i] = i;
                for (int j = 2; j <= i; j++) {
                    dp[j][i] = dp[j-1][i-1] + dp[j][i-1];
                }
            }

            result[t] = dp[N][M];

        }

        for(int i = 0 ; i < T; i++) {
            System.out.println(result[i]);
        }

    }
}