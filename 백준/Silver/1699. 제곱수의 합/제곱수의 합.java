import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];

        dp[1] = 1; // 1
        dp[2] = 2; // 1 1
        dp[3] = 3; // 1 1 1
        dp[4] = 1; // 2^2
        dp[5] = 2; // 2^2 + 1^2
        dp[6] = 3; // 2^2 + 1^2 + 1^2
        dp[7] = 4; // 2^2 + 1^2 + 1 + 1
        dp[8] = 2; // 2^2 + 2^2
        dp[9] = 1;
        //101 = 10^2 + 1
        //250 = 15^2 + 5^2 =
        //253 = 15^2 + 5^2 +
        //82009 = 286^2 + 14^2 + 4^2 + 1^2 / 285^2 + 28^2

        for (int i = 3; i <= n; i++) {
            if(Math.pow(i, 2) <= 100000)
                dp[(int) Math.pow(i, 2)] = 1;

            if(dp[i] != 0)
                continue;
            else {
                dp[i] = 1 + dp[i-1];
                for (int j = 2; j <= i / 2; j++) {
                    int temp = dp[j] + dp[i-j];

                    if(temp < dp[i])
                        dp[i] = temp;
                }
            }

        }

        System.out.println(dp[n]);
    }
}