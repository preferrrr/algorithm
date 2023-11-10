import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            dfs(i, i);
            Arrays.fill(visited, false);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }



        System.out.print(sb);
    }

    static void dfs(int cur, int v) {


        List<Integer> list = graph.get(v);

        for (int i = 0; i < list.size(); i++) {
            if (!visited[list.get(i)]) {
                visited[list.get(i)] = true;
                arr[cur][list.get(i)] = 1;
                dfs(cur, list.get(i));

            }
        }

    }


}