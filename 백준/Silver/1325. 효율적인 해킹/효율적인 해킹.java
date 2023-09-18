import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static Map<Integer, ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(b).add(a);
        }

        // 1 : 3 /
        // 2 : 3
        // 3 : 4 5

        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            count[i] = bfs(i);
        }

        int max = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if(count[i] > max) {
                max = count[i];
                queue.clear();
                queue.add(i);
            } else if(count[i] == max) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }


    }

    static int bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start] = true;
        int count = -1;

        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            count++;
            List<Integer> list = graph.get(poll);

            for (int temp : list) {
                if (!visited[temp]) {
                    visited[temp] = true;
                    deque.add(temp);
                }
            }
        }

        return count;

    }
}