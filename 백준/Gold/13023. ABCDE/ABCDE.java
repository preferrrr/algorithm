import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int result = 0;
    static boolean[] visited;
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(result);
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
    }

    static void solve() {
        for (int i = 0; i < n; i++) {
            if (result == 0)
                dfs(i, 1);
        }
    }

    static void dfs(int cur, int d) {

        if (d == 5) {
            result = 1;
            return;
        }

        visited[cur] = true;

        ArrayList<Integer> linked = map.get(cur);

        for (int i = 0; i < linked.size(); i++) 
            if (!visited[linked.get(i)]) 
                dfs(linked.get(i), d + 1);

        visited[cur] = false;
    }
}