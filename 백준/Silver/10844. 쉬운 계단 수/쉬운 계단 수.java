import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static final int MOD = 1000000000;

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new long[10][n + 1];

        for (int i = 0; i <= 9; i++) {
            dp[i][1] = 1;
        }
    }

    static long solve() {

        if (n == 1)
            return 9;

        for (int i = 2; i <= n; i++) {
            dp[0][i] = dp[1][i - 1];

            for (int j = 1; j <= 8; j++) {
                dp[j][i] = (dp[j + 1][i - 1] % MOD + dp[j - 1][i - 1] % MOD) % MOD;
            }
            dp[9][i] = dp[8][i - 1];
        }

        long result = 0;

        for (int i = 1; i <= 9; i++) {
            result += dp[i][n];
            result %= MOD;

        }

        return result;
    }
}