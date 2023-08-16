import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node node = new Node();
            node.pay = Integer.parseInt(st.nextToken());
            node.day = Integer.parseInt(st.nextToken());
            queue.add(node);
        }

        int cur = 0;

        PriorityQueue<Node> result = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.pay == o2.pay)
                    return o1.day - o2.day;
                return o1.pay - o2.pay;
            }
        });

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.day - cur > 0) {
               result.add(node);
               cur++;
            } else {
                Node temp = result.peek();
                if(node.pay > temp.pay) {
                    result.poll();
                    result.add(node);
                }
            }
        }

        int total = 0;
        while(!result.isEmpty()) {
            total += result.poll().pay;
        }

        System.out.println(total);

    }

    static class Node implements Comparable<Node> {
        int pay;
        int day;

        @Override
        public int compareTo(Node o) {
            if (this.day == o.day)
                return o.pay - this.pay;
            return this.day - o.day;
        }
    }
}