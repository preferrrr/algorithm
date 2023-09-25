import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node> list = new ArrayList<>();
    static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                Node node = new Node(a, b);

                list.add(node);
                graph.put(i, new ArrayList<>());
            }

            for (int i = 0; i < n + 2; i++) {
                Node a = list.get(i);
                for (int j = i + 1; j < n + 2; j++) {
                    Node b = list.get(j);
                    if (dist(a, b) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            boolean result = bfs(n);

            if(result)
                sb.append("happy\n");
            else sb.append("sad\n");

            graph.clear();
            list.clear();

        }

        System.out.print(sb);
    }

    static boolean bfs(int n) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 2];
        deque.add(0);
        visited[0] = true;

        while(!deque.isEmpty()) {
            int poll = deque.pollFirst();
            if(poll == n + 1)
                return true;
            List<Integer> list = graph.get(poll);

            for(int i = 0 ; i < list.size(); i++) {
                int temp = list.get(i);
                if(!visited[temp]) {
                    visited[temp] = true;
                    deque.addLast(temp);
                }
            }
        }

        return false;
    }

    static int dist(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}