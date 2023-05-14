import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken(" "));
            int n = Integer.parseInt(st.nextToken(" "));

            int[][] list = new int[m][n];

            int k = Integer.parseInt(st.nextToken(" "));

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                list[Integer.parseInt(st.nextToken(" "))][Integer.parseInt(st.nextToken(" "))] = 1;
            }
            int count = 0;

            for (int a = 0; a < m; a++) {
                for (int b = 0; b < n; b++) {
                    if (list[a][b] == 1) {
                        count++;
                        dfs(list, a, b, m, n);
                    }
                }
            }
            System.out.println(count);
        }
    }
    static int ADJ = 2;
    public static void dfs(int[][] list, int x, int y, int m, int n) {
        if ((x < 0 || y < 0 || x >= m || y >= n) || list[x][y] != 1) {
            return;
        } else {
            list[x][y] = ADJ;
            dfs(list, x - 1, y, m, n);
            dfs(list, x, y + 1, m, n);
            dfs(list, x + 1, y, m, n);
            dfs(list, x, y - 1, m, n);
        }
    }
}