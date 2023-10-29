import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 5;
        dp[6] = 8;

        for (int i = 7; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
        // 1
        // 1 + 0
        // 10 + 0, 10 + 1
        // 100 + 0, 100 + 1, 101 + 0
        // 1000 + 0, 1000 + 1, 1001 + 0, 1010 + 0, 1010 + 1
        // 10000 0, 10000 1, 10001 0, 10010 0, 10010 1, 10100 0, 10100 1, 10101 0
    }
}