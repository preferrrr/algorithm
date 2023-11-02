import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long result = dfs(n-1, n-1);
        System.out.println(result);

    }
    
    static long dfs(int x, int y) {

        if(x == 0 && y == 0)
            return 1;

        if(dp[x][y] != 0)
            return dp[x][y];


        for(int i = 0; i < x; i++) {
            if (x - i == arr[i][y]) {
                dp[x][y] += dfs(i, y);
            }
        }

        for(int j = 0 ; j < y; j++) {
            if(y - j == arr[x][j])
                dp[x][y] += dfs(x, j);
        }

        return dp[x][y];
    }
}