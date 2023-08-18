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
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Node node = new Node(start, end);
            list.add(node);

        }

        Collections.sort(list);

        int result = 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(list.get(0).end);

        for(int i = 1 ; i < list.size(); i++) {

            if(!queue.isEmpty() && list.get(i).start < queue.peek()) {
                queue.add(list.get(i).end);
                if(result < queue.size())
                    result = queue.size();
            } else {
                while(!queue.isEmpty() && list.get(i).start >= queue.peek()) {
                    queue.poll();
                }
                queue.add(list.get(i).end);
            }

        }

        System.out.println(result);

    }

    static class Node implements Comparable<Node> {
        int start;
        int end;

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
}