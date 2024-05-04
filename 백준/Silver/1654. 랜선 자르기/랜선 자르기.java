import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static long max;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        max = 0;

        arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max)
                max = arr[i];
        }
    }

    static void solve() {
        long left = 1;
        long right = max + 1;

        while (left < right) {
            long mid = (left + right) / 2;

            int count = 0;

            for (int i = 0; i < n; i++)
                count += arr[i] / mid;

            if (count >= k)
                left = mid + 1;
            else
                right = mid;
        }

        System.out.println(left - 1);
    }
}