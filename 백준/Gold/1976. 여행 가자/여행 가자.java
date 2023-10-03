import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> plan = new ArrayList<>();

        for (int i = 0; i < m; i++)
            plan.add(Integer.parseInt(st.nextToken()));

        boolean result = isPossible(plan);

        if(result)
            System.out.println("YES");
        else System.out.println("NO");

    }

    static boolean check = false;
    static boolean isPossible(List<Integer> plan) {
        for (int i = 0; i < m - 1; i++) {

            dfs(visited, plan.get(i), plan.get(i + 1));

            if(!check)
                return false;

            check = false;
            Arrays.fill(visited, false);

        }

        return true;
    }

    static void dfs(boolean[] visited, int cur, int goal) {
        if (cur == goal)
            check = true;

        visited[cur] = true;

        List<Integer> linked = graph.get(cur);

        for (int v : linked) {
            if (!visited[v])
                dfs(visited, v, goal);
        }

    }
}