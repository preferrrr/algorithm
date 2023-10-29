import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[101][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];

            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] % MOD + dp[i - 1][j + 1] % MOD) % MOD;
            }

            dp[i][9] = dp[i - 1][8];
        }

        long result = 0;
        for (int i = 1; i <= 9; i++) {
            result += dp[n][i];
            result %= 1000000000;
        }

        System.out.println(result);

    }
}