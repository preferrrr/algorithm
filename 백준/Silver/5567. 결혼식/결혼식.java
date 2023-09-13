import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Integer, ArrayList<Integer>> graph;

    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new HashMap();
        for(int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        visited = new int[n + 1];
        Arrays.fill(visited, -1);

        for(int i = 0 ; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);

        int result = 0;

        for(int i = 2; i <= n; i++) {
            if(visited[i] <= 2 && visited[i] != -1)
                result++;
        }
        System.out.println(result);

    }

    static void bfs(int start) {
        visited[start] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        while(!deque.isEmpty()) {
            int poll = deque.pollFirst();
            if(visited[poll] >= 2)
                break;
            List<Integer> list = graph.get(poll);

            for (int temp : list) {
                if(visited[temp] == -1) {
                    visited[temp] = visited[poll] + 1;
                    deque.addLast(temp);
                }
            }
        }

    }
}