import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Node> nodes = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static class Node implements Comparable<Node> {
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }
    }

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodes.add(new Node(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        Collections.sort(nodes);

    }

    static int solve() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(nodes.get(0).end);

        for(int i = 1 ; i < n; i++) {
            if(queue.peek() <= nodes.get(i).start)
                queue.poll();

            queue.add(nodes.get(i).end);

        }

        return queue.size();
    }

}