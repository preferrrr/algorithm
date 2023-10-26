import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Node> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        deque.add(new Node(n, 0));
        visited[n] = true;

        int result = -1;

        while (!deque.isEmpty()) {
            Node cur = deque.pollFirst();
            if(cur.x == 1)
                result = cur.w;

            if (!visited[cur.x / 3] && cur.x % 3 == 0 && cur.x / 3 > 0) {
                visited[cur.x / 3] = true;
                deque.add(new Node(cur.x / 3, cur.w + 1));
            }

            if (!visited[cur.x / 2] && cur.x % 2 == 0 && cur.x / 2 > 0) {
                visited[cur.x / 2] = true;
                deque.add(new Node(cur.x / 2, cur.w + 1));
            }

            if (!visited[cur.x - 1] && cur.x - 1 > 0) {
                visited[cur.x - 1] = true;
                deque.add(new Node(cur.x - 1, cur.w + 1));
            }
        }

        System.out.println(result);
    }

    static class Node {
        int x, w;

        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }
}