import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, max = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max)
                max = arr[i];
        }

        m = Integer.parseInt(br.readLine());
    }

    static void solve() {

        int left = 0;
        int right = max + 1;

        while (left < right) {

            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 0 ; i < arr.length; i++) {
                if (arr[i] > mid) {
                    count += mid;
                } else {
                    count += arr[i];
                }
            }

            if (count <= m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left - 1);
    }
}