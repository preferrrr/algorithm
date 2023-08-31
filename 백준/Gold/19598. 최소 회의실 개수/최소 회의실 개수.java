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
            node.start = Integer.parseInt(st.nextToken());
            node.end = Integer.parseInt(st.nextToken());
            list.add(node);
        }

        Collections.sort(list);

        PriorityQueue<Integer> result = new PriorityQueue<>();
        result.add(list.get(0).end);

        for(int i = 1 ; i < n; i++) {
            Node temp = list.get(i);
            if(result.peek() <= temp.start) {
                result.poll();
                result.add(temp.end);
            } else {
                result.add(temp.end);
            }
        }

        System.out.println(result.size());

    }

    public static class Node implements Comparable<Node> {
        int start;
        int end;

        @Override
        public int compareTo(Node o) {
            if (this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }
    }
}