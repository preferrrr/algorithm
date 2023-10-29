import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[2][n + 2];
        dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }


        //dfs(1, 0);


        for (int i = n; i >= 1; i--) {
            if (i + arr[0][i] <= n + 1) {
                dp[i] = Math.max(dp[i + arr[0][i]] + arr[1][i], dp[i + 1]);
            } else
                dp[i] = dp[i + 1];
        }

        max = dp[1];

        System.out.println(max);


    }

    static int max = 0;

    static void dfs(int cur, int p) {


        if (cur > n + 1)
            return;
        if (p > max)
            max = p;
        if (cur < n + 1) {
            dfs(cur + arr[0][cur], p + arr[1][cur]);
            dfs(cur + 1, p);
        }


    }

}