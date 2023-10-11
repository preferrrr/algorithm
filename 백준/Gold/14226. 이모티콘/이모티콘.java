import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int end = Integer.parseInt(br.readLine());

        Deque<Node> deque = new ArrayDeque<>();
        boolean[][] clipboard = new boolean[1001][1001];

        deque.add(new Node(1, 0, 0));
        clipboard[1][0] = true;

        int result = -1;
        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            if (poll.v == end) {
                result = poll.w;
                break;
            }

            //복사
            if (poll.v + poll.v <= 1000 && !clipboard[poll.v][poll.v]) {
                deque.add(new Node(poll.v, poll.v, poll.w + 1));
                clipboard[poll.v][poll.v] = true;
            }
            //붙여넣기
            if (poll.v + poll.clipboard <= 1000 && !clipboard[poll.v + poll.clipboard][poll.clipboard]) {
                deque.add(new Node(poll.v + poll.clipboard, poll.clipboard, poll.w + 1));
                clipboard[poll.v + poll.clipboard][poll.clipboard] = true;
            }
            //지우기
            if (poll.v - 1 > 0 && !clipboard[poll.v - 1][poll.clipboard]) {
                deque.add(new Node(poll.v - 1, poll.clipboard, poll.w + 1));
                clipboard[poll.v -1][poll.clipboard] = true;
            }
        }

        System.out.println(result);


    }

    static class Node implements Comparable<Node> {
        int v, w, clipboard;

        public Node(int v, int clipboard, int w) {
            this.v = v;
            this.w = w;
            this.clipboard = clipboard;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}