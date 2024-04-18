import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int t, n, m;
    static int[] arr1, arr2;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < t; i++) {
            input();
            solve();
        }

        System.out.print(result);
    }

    public static void input() throws IOException {

        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
    }

    public static void solve() {

        for (int i = 0 ; i < m; i++) {
            int left = 0;
            int right = n - 1;
            boolean find = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr1[mid] == arr2[i]) {
                    find = true;
                    break;
                } else if (arr1[mid] > arr2[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (find)
                result.append(1).append("\n");
            else result.append(0).append("\n");
        }
    }

}