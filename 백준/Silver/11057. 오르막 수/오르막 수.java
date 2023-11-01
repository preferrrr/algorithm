import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[1001][11];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }


        //00 ~ 09 : 10
        //11 ~ 19 : 9
        //...
        //99 ~ 99 : 1

        for (int i = 2; i <= n; i++) {
            for (int j = 9; j >= 0; j--) {
                dp[i][j] = (dp[i][j+1] + dp[i-1][j]) % 10007;
            }
        }

        int sum = 0;
        for(int i = 0; i <= 9; i++) {
            sum = (sum + dp[n][i]) % 10007;
        }

        System.out.println(sum);

    }
}