import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {

                if (dp[i + 1][j] < dp[i][j] + arr[i + 1][j])
                    dp[i + 1][j] = dp[i][j] + arr[i + 1][j];

                if (dp[i + 1][j + 1] < dp[i][j] + arr[i + 1][j + 1])
                    dp[i + 1][j + 1] = dp[i][j] + arr[i + 1][j + 1];

            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] > max)
                max = dp[n - 1][i];
        }

        System.out.println(max);


    }
}