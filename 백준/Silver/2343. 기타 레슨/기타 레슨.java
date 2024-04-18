import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static int left, right;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] > left)
                left = arr[i];
            right += arr[i];
        }


    }

    public static void solve() {

        while (left < right) {
            int mid = (left + right) / 2;

            int count = 1;
            int length = 0;
            for (int i = 0 ; i < n; i++) {
                if (length + arr[i] <= mid) {
                    length += arr[i];
                } else {
                    count++;
                    length = arr[i];
                }
            }

            if (count > m) {  // 블루레이가 m개보다 많이 필요해. mid를 늘려야 함. left = mid + 1
                left = mid + 1;
            } else { // 블루레이가 m개보다 작게 필요해. mid를 줄여도 된다. => right = mid;
                right = mid;
            }
        }

        System.out.println(left);
    }


}