import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        for (int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            list.add(new Node(day, score));
        }

        Collections.sort(list);

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.score == o2.score)
                    return o1.day - o2.day;
                return o1.score - o2.score;
            }
        });

        int cur = 0;

        for(int i = 0 ; i < n; i++) {
            Node node = list.get(i);
            if(node.day - cur > 0) {
                queue.add(node);
                cur++;
            } else if(queue.peek().score < node.score) {
                queue.poll();
                queue.add(node);
            }
        }

        int result = 0;
        while(!queue.isEmpty()) {
            result += queue.poll().score;
        }

        System.out.println(result);


    }

    static class Node implements Comparable<Node>{
        int day;
        int score;

        public Node (int day, int score) {
            this.day = day;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            if(this.day == o.day)
                return o.score - this.score;
            return this.day - o.day;
        }
    }
}