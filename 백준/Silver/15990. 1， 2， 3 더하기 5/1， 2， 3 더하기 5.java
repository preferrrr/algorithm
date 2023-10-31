import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        //1 : 1 => 1
        //2 : 2 => 1
        //3 : 12, 21, 3 => 3
        //4 : 121 13 31 => 3
        //5 : 131 212 23 32 => 4
        //6 : 1212 2121 123*6  => 8

        long[][] dp = new long[100001][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 4; i <= n; i++) {
                dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
                dp[i][2] = (dp[i - 2][3] + dp[i - 2][1]) % 1000000009;
                dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
            }

            long sum = 0;

            for (int i = 1; i <= 3; i++) {
                sum += dp[n][i];
            }
            sb.append(sum % 1000000009).append("\n");
        }

        System.out.print(sb);
    }
}