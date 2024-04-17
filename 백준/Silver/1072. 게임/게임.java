import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x, y;
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        long rate = y * 100 / x;
        long left = 0;
        long right = x;

        if (rate >= 99)
            System.out.println(-1);
        else {
            while (left < right) {
                long mid = (left + right) / 2;
                //조건을 만족하는 가장 작은 mid를 찾아야 해.
                //조건 : rate보다 temp가 커야함.
                long temp = (y + mid) * 100 / (x + mid);

                if (rate >= temp) {
                    left = mid + 1;
                } else {
                    right = mid;
                }

            }

            System.out.println(right);
        }

    }
}