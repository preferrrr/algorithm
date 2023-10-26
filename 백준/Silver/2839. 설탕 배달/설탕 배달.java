import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //3=1, 5=1, 6=2, 8=2, 9=3
        //n이 되는 방법은 (n-3)+3, (n-5)+5 두 가지 방법이 있는데,
        //두 가지 방법 중 저 작은거가 답이 됨.

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[3] = 1;
        if(n >= 5)
            dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            if(dp[i-3] != -1 && dp[i-5] != -1){
                dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
            }
            else if(dp[i-3] == -1 && dp[i-5] != -1) {
                dp[i] = dp[i-5] + 1;
            } else if(dp[i-5] == -1 && dp[i-3] != -1) {
                dp[i] = dp[i-3] + 1;
            }
        }

        System.out.println(dp[n]);
    }
}