import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long x, y;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());

    }

    static void solve() {
        long p = y * 100 / x;

        long left = 0;
        long right = x;

        if (p >= 99) {
            System.out.println(-1);
            return;
        }

        while (left < right) {
            long mid = (left + right) / 2;

            long x2 = x + mid;
            long y2 = y + mid;
            long p2 = y2 * 100 / x2;

            if (p2 <= p)
                left = mid + 1;
            else right = mid;
        }

        System.out.println(left);
    }


}