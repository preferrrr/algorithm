import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(graph, 1);

        System.out.println(result);
    }

    static void dfs(Map<Integer, ArrayList<Integer>> graph, int start) {
        visited[start] = true;

        ArrayList<Integer> list = graph.get(start);

        for(int i = 0; i < list.size(); i++) {
            if(!visited[list.get(i)]) {
                result++;
                dfs(graph, list.get(i));
            }
        }
    }
}