import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dfs(0, 0, 0);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        System.out.println(dp[n][m]);

    }

    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 1, 0};

    static void dfs(int i, int j, int count) {

        if (dp[i][j] < arr[i][j] + count)
            dp[i][j] = arr[i][j] + count;
        else return;

        if (i == n - 1 && j == m - 1)
            return;

        for (int d = 0; d < 3; d++) {
            int x = i + dx[d];
            int y = j + dy[d];

            if (x >= 0 && y >= 0 && x < n && y < m) {
                dfs(x, y, dp[i][j]);
            }
        }
    }

}