import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1];

            dp[1] = 1;
            if(n >= 2)
                dp[2] = 2;
            if(n >= 3)
                dp[3] = 4;
            if(n >= 4)
                dp[4] = 7;
            for (int i = 5; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}