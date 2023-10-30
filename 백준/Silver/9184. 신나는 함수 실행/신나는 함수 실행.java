import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                break;

            w(a + 50, b + 50, c + 50);

            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(dp[a + 50][b + 50][c + 50]).append("\n");
        }

        System.out.print(sb);
    }

    static int w(int a, int b, int c) {
        if (dp[a][b][c] != 0)
            return dp[a][b][c];

        if (a <= 50 || b <= 50 || c <= 50) {
            return dp[a][b][c] = 1;
        }

        if (a > 70 || b > 70 || c > 70) {
            return dp[a][b][c] = w(70, 70, 70);
        }

        if (a < b && b < c)
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);

        else
            return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}