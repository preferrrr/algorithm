import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int t, n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] a, b;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < t; i++) {
            input();
            solve();
        }

        System.out.print(sb);
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        Arrays.sort(b);

        //8 1 7 3 1
        //1 3 6
        int count = 0;

        for (int i = 0 ; i < n; i++) {
            int left = 0;
            int right = m;

            while (left < right) {
                int mid = (left + right) / 2;

                if(b[mid] < a[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            count += left;

        }

        sb.append(count).append("\n");

    }
}