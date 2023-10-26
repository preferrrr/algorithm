import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        dp = new int[x + 1];
        dp[1] = 0;

        dfs(x);

        System.out.println(dp[x]);
        
    }

    static int dfs(int n) {
        if(n == 1 || dp[n] != 0)
            return dp[n];
        if (n % 3 == 0 && n % 2 == 0) {
            return dp[n] = Math.min(dfs(n / 3) + 1, dfs(n / 2) + 1);
        } else if (n % 3 == 0) {
            return dp[n] = Math.min(dfs(n / 3) + 1, dfs(n - 1) + 1);
        } else if (n % 2 == 0) {
            return dp[n] = Math.min(dfs(n / 2) + 1, dfs(n - 1) + 1);
        } else
            return dp[n] = dfs(n - 1) + 1;
    }
}