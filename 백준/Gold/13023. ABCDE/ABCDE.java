import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0 ; i < n; i++) {
            if(!result)
                dfs(i, 1);
        }

        if(result)
            System.out.println(1);
        else System.out.println(0);


    }
    static boolean result = false;

    static void dfs(int cur, int d) {
        if(d == 5) {
            result = true;
            return;
        }
        visited[cur] = 1;

        List<Integer> list = graph.get(cur);

        for(int v : list) {
            if(visited[v] == 0) {
                dfs(v, d + 1);
            }
        }
        visited[cur] = 0;
    }
}