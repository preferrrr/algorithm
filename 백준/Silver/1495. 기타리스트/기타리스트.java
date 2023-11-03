import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][s] = true;
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j <= m; j++) {
                if(dp[i][j]) {
                    if(j + arr[i] <= m)
                        dp[i+1][j + arr[i]] = true;

                    if(j - arr[i] >= 0)
                        dp[i+1][j - arr[i]] = true;
                }
            }
        }

        boolean flag = false;
        for(int i = m; i >= 0; i--) {
            if(dp[n][i]) {
                System.out.println(i);
                flag = true;
                break;
            }
        }

        if (!flag)
            System.out.println(-1);


    }
}