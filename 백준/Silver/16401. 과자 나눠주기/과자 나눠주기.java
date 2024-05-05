import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    static void solve() {
        int left = 1;
        int right = arr[n - 1] + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] / mid == 0)
                    break;
                else count += arr[i] / mid;
            }

            if (count >= m)
                left = mid + 1;
            else right = mid;
        }

        System.out.println(left - 1);
    }
}