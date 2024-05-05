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

        arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max)
                max = arr[i];
        }
    }

    static void solve() {
        int left = 1;
        int right = max + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 0 ; i < m; i++) {
                count += arr[i] / mid;
                if (arr[i] % mid != 0)
                    count++;
            }

            if (count > n)
                left = mid + 1;
            else right = mid;
        }

        System.out.println(left);
    }
}