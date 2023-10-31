import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        for (int i = 0; i < n; i++) {

            if(dp[i] == Integer.MAX_VALUE)
                break;
            for (int j = i + 1; j <= i + arr[i] && j < n; j++) {
                if (dp[j] > dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                }
            }
        }

        if(dp[n-1] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[n - 1]);
    }
}