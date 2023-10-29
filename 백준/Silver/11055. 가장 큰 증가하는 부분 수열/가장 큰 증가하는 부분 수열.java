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
            int temp = -1;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i] && arr[j] > temp && dp[i] < arr[i] + dp[j]) {
                    dp[i] = arr[i] + dp[j];
                    temp = arr[j];
                }
            }
            if (temp == -1)
                dp[i] = arr[i];

            if(dp[i] > max)
                max = dp[i];
        }

        System.out.println(max);

    }

}