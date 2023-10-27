import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0, 1, 2 각각을 시작으로.

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            dfs(0, i, 0);
            for (int j = 0; j < 3; j++) {
                if (result > dp[n - 1][j])
                    result = dp[n - 1][j];
            }
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[j], 0);
            }
        }

        System.out.println(result);

    }


    static void dfs(int x, int y, int before) {

        if (dp[x][y] == 0 || dp[x][y] > before + arr[x][y]) {
            dp[x][y] = arr[x][y] + before;
        }
        else return;

        if (x == n - 1)
            return;

        if (y == 0) {
            dfs(x + 1, 1, dp[x][y]);
            dfs(x + 1, 2, dp[x][y]);
        } else if (y == 1) {
            dfs(x + 1, 0, dp[x][y]);
            dfs(x + 1, 2, dp[x][y]);
        } else {
            dfs(x + 1, 0, dp[x][y]);
            dfs(x + 1, 1, dp[x][y]);
        }

    }
}