import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = dfs(n);
        
        System.out.println(max);
    }


    static int dfs(int cur) {

        if(dp[cur] != 0 || cur == 0)
            return dp[cur];

        dp[cur] = arr[cur];

        for(int i = 0; i <= cur/2; i++) {
            int temp = dfs(i) + dfs(cur - i);
            if(dp[cur] < temp)
                dp[cur] = temp;
        }

        return dp[cur];
    }
}