import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testcase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][100000];
            int[][] dp = new int[2][100000];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[0][i] = Integer.parseInt(st1.nextToken());
                arr[1][i] = Integer.parseInt(st2.nextToken());
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            dp[0][1] = arr[0][1] + arr[1][0];
            dp[1][1] = arr[1][1] + arr[0][0];

            int max = Math.max(dp[0][0], Math.max(dp[1][0], Math.max(dp[0][1], dp[1][1])));
            for (int i = 2; i < n; i++) {

                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];

                if (max < dp[0][i])
                    max = dp[0][i];
                if (max < dp[1][i])
                    max = dp[1][i];
            }

            sb.append(max).append("\n");


        }

        System.out.print(sb);

    }
}