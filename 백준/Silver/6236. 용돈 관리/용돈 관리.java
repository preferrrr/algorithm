import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = 0;

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max)
                max = arr[i];
        }
    }

    static void solve() {
        long left = max;
        long right = n * 10000;

        while (left < right) {
            long mid = (left + right) / 2;

            int count = 1;
            long temp = mid;
            for (int i = 0; i < n; i++) {
                if (temp >= arr[i])
                    temp -= arr[i];
                else {
                    temp = mid - arr[i];
                    count++;
                }
            }

            if (count > m)
                left = mid + 1;
            else right = mid;
        }

        System.out.println(left);
    }
}