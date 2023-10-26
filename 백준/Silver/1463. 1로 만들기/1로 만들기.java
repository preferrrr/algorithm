import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int[] dp = new int[x + 1];
        Arrays.fill(dp, 1000001);
        dp[1] = 0;

        //어떤 숫자가 되는 방법은 2나 3을 곱해서 되거나 1 더하기

        for (int i = 2; i <= x; i++) {

            if(i % 3 == 0 && i / 3 > 0 && dp[i] > dp[i / 3] + 1)
                dp[i] = dp[i / 3] + 1;

            if(i % 2 == 0 && i / 2 > 0 && dp[i] > dp[i/2] + 1)
                dp[i] = dp[i / 2] + 1;
            if(i - 1 > 0 && dp[i] > dp[i-1] + 1)
                dp[i] = dp[i - 1] + 1;

        }

        System.out.println(dp[x]);

    }
}