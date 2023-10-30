import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int max = arr[0];
        //1 101 3 53 113 6 11 17 24 32
        for (int i = 1; i < n; i++) {
            dp[i] = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i] // 현재 수보다 작아야함
                        && dp[i] < arr[i] + dp[j]) { //처음엔 0이기 때문에 true, 현재 수보다 작은 수들 중 최대값이어도 누적값은 최대가 아닐 수 있음
                    // 5 1 2 3 10 중 1 2 3 10이 최대가 되어야 함.
                    dp[i] = arr[i] + dp[j];
                }
            }

            if(dp[i] > max)
                max = dp[i];
        }

        System.out.println(max);

    }

}