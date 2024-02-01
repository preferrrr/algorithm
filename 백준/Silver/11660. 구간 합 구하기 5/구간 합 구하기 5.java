import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr, dp;

    static List<Node> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        System.out.print(solve());
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = arr[i][j] + dp[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            nodes.add(new Node(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

    }

    static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < m; t++) {
            Node node = nodes.get(t);

            int result = 0;
            for (int i = node.x1; i <= node.x2; i++) {
                result += dp[i][node.y2] - dp[i][node.y1 - 1];
            }

            sb.append(result).append("\n");
        }

        return sb.toString();
    }


    static class Node {
        int x1, y1, x2, y2;

        public Node(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}