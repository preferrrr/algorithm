import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        input();
        solve();
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    static void solve() throws IOException {
        m = Integer.parseInt(br.readLine());

        int[] result = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] == num) {
                    result[i] = 1;
                    break;
                } else if (arr[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        for (int i = 0 ; i < m; i++) {
            System.out.print(result[i] + " ");
        }
    }
}