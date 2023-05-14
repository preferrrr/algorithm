import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int[] result;
    static boolean[] visit;
    static int n;
    static int m;
    static int start;


    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        start = Integer.parseInt(st.nextToken(" "));

        result = new int[m];
        visit = new boolean[n + 1];

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            graph.put(i,new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken(" "));
            int val = Integer.parseInt(st.nextToken(" "));

            graph.get(key).add(val);
            graph.get(val).add(key);

//            if (graph.containsKey(key)) {
//                graph.get(key).add(val);
//
//                if (graph.containsKey(val))
//                    graph.get(val).add(key);
//                else {
//                    ArrayList keys = new ArrayList<>();
//                    keys.add(key);
//                    graph.put(val, keys);
//                }
//            } else {
//                ArrayList<Integer> value = new ArrayList<>();
//                value.add(val);
//                graph.put(key, value);
//
//                if (graph.containsKey(val))
//                    graph.get(val).add(key);
//                else {
//                    ArrayList keys = new ArrayList<>();
//                    keys.add(key);
//                    graph.put(val, keys);
//                }
//
//            }
        }

        dfs(graph, 0, start);

        sb.append("\n");
        visit = new boolean[n + 1];

        bfs(graph,start);

        System.out.println(sb);
    }

    public static void dfs(HashMap<Integer, ArrayList<Integer>> graph, int depth, int start) {
        visit[start] = true;
        sb.append(start + " ");

        Collections.sort(graph.get(start));
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (!visit[graph.get(start).get(i)]) {
                dfs(graph, depth + 1, graph.get(start).get(i));
            }
        }

    }

    public static void bfs(HashMap<Integer, ArrayList<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start + " ");

            for (int i = 0; i < graph.get(start).size(); i++) {
                if(!visit[graph.get(start).get(i)]) {
                    queue.add(graph.get(start).get(i));
                    visit[graph.get(start).get(i)] = true;
                }
            }
        }


    }
}