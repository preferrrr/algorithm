import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        List<Integer> result = bfs();

        StringBuilder sb = new StringBuilder();

        result.stream().forEach(x -> sb.append(x + " "));
        System.out.println(sb);


    }

    static class Node {
        int a, b, c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static List<Integer> bfs() {
        Deque<Node> deque = new ArrayDeque<>();
        boolean[][][] visited = new boolean[a + 1][b + 1][c + 1];
        List<Integer> result = new ArrayList<>();
        deque.add(new Node(0, 0, c));

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();
            int A = poll.a;
            int B = poll.b;
            int C = poll.c;

            if (visited[A][B][C])
                continue;
            visited[A][B][C] = true;

            if (A == 0)
                result.add(C);

            //A -> B
            if (A + B >= b)
                deque.addLast(new Node(A - (b - B), b, C));
            else deque.add(new Node(0, A + B, C));
            //A -> C
            if (A + C >= c)
                deque.add(new Node(A - (c - C), B, c));
            else deque.add(new Node(0, B, A + C));
            //B -> A
            if (B + A >= a)
                deque.add(new Node(a, B - (a - A), C));
            else deque.add(new Node(B + A, 0, C));
            //B -> C
            if (B + C >= c)
                deque.add(new Node(A, B - (c - C), c));
            else deque.add(new Node(A, 0, B + C));
            //C -> A
            if (C + A >= a)
                deque.add(new Node(a, B, C - (a - A)));
            else deque.add(new Node(A + C, B, 0));
            //C -> B
            if (C + B >= b)
                deque.add(new Node(A, b, C - (b - B)));
            else deque.add(new Node(A, B + C, 0));
        }

        Collections.sort(result);

        return result;

    }
}