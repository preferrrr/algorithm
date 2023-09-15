import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] friends;
    static Map<Integer, ArrayList<Integer>> graph;
    static int[] result;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        friends = new int[n + 1];
        graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(!graph.get(a).contains(b)) {
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
        }

        result = new int[n + 1];

        for(int i = 1 ; i <= n; i++) {
            result[i] = bfs(i);
        }

        int min = 1;
        for(int i = 1; i <= n; i++) {
            if(result[i] < result[min])
                min = i;
        }

        System.out.println(min);



    }

    static int bfs(int start) {

        Deque<Integer> deque = new ArrayDeque<>();

        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);

        deque.add(start);
        visited[start] = 0;


        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();

            List<Integer> list = graph.get(poll);

            for(int i = 0 ; i < list.size(); i++) {
                if(visited[list.get(i)] == -1) {
                    visited[list.get(i)] = visited[poll] + 1;
                    deque.add(list.get(i));
                }
            }
        }

        int result = 0;

        for(int i = 0 ; i < n; i++) {
            result += visited[i + 1];
        }

        return result;
    }

}