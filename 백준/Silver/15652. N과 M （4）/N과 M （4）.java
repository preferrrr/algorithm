import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

    static boolean[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken(" "));
        visit = new boolean[n];
        arr = new int[m];

        dfs(n, m, 0, 0);

        System.out.println(sb);

    }

    public static void dfs(int n, int m, int prev, int depth) {
        if (m == depth) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = prev; i < n; i++) {
            if (!visit[i] || arr[depth-1] - 1 == i) {
                visit[i] = true;
                arr[depth] = i+1; // arr[0] = 1
                dfs(n, m, arr[depth] - 1, depth + 1); // n m 0 1
                visit[i] = false;
            }
        }
    }
}