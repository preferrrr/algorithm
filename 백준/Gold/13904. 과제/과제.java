import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node node = new Node();
            node.day = Integer.parseInt(st.nextToken());
            node.score = Integer.parseInt(st.nextToken());
            list.add(node);
        }

        Collections.sort(list);

        int sub = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.score == o2.score)
                    return o1.day - o2.day;
                return o1.score - o2.score;
            }
        });

        for (int i = 0; i < n; i++) {
            Node node = list.get(i);

            if (node.day - sub > 0) {
                queue.add(node);
                sub++;
            } else {
                if (queue.peek().score < node.score) {
                    queue.poll();
                    queue.add(node);
                }
            }

        }

        int total = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            total += node.score;
        }

        System.out.println(total);
    }

    static class Node implements Comparable<Node> {
        int day;
        int score;

        @Override
        public int compareTo(Node o) {
            if (this.day == o.day)
                return o.score - this.score;
            return this.day - o.day;
        }
    }
}