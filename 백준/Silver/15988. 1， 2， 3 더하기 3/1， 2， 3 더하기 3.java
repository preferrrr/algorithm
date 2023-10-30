import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        //1 : 1 / 1
        //2 : 11, 2 / 2
        //3 : 111 12 21 3 / 4
        //4 : 1111 112 121 211 22 31 13 / 7
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;
        for (int t = 0; t < test; t++) {
            int n = Integer.parseInt(br.readLine());

            for(int i = 5; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
            }
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}