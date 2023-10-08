import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = 0;

        boolean[] visited = new boolean[100001];

        Deque<Node> deque = new ArrayDeque<>();

        deque.add(new Node(n, 0));
        visited[n] = true;

        int min = Integer.MAX_VALUE;
        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            visited[poll.v] = true;


            if (poll.v == k) {
                if (min > poll.w)
                    min = poll.w;
                if (poll.w == min)
                    result++;

                continue;
            }

            if (poll.v + 1 <= 100000 && !visited[poll.v + 1]) {
                deque.add(new Node(poll.v + 1, poll.w + 1));
            }
            if (poll.v - 1 >= 0 && !visited[poll.v - 1]) {
                deque.add(new Node(poll.v - 1, poll.w + 1));
            }
            if (poll.v * 2 <= 100000 && !visited[poll.v * 2]) {
                deque.add(new Node(poll.v * 2, poll.w + 1));
            }
        }

        System.out.println(min + "\n" + result);
    }

    static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}