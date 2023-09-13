import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] visited;
    static Map<Integer, ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();

        visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        Arrays.fill(visited, -1);

        bfs(x);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < visited.length; i++) {
            if(visited[i] == k)
                sb.append(i + "\n");
        }


        if(sb.toString().isEmpty())
            System.out.println(-1);
        else System.out.print(sb);



    }

    static void bfs(int start) {

        visited[start] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        while(!deque.isEmpty()) {
            int poll = deque.pollFirst();

            List<Integer> list = graph.get(poll);

            for(int i = 0 ; i < list.size(); i++) {
                if(visited[list.get(i)] == -1) {
                    visited[list.get(i)] = visited[poll] + 1;
                    deque.add(list.get(i));
                }
            }
        }


    }
}