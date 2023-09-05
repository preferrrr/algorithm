import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Node node = new Node(a, b);
            queue.add(node);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());


        PriorityQueue<Integer> tmp = new PriorityQueue<>(Comparator.reverseOrder());

        int result = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            while (!tmp.isEmpty() && p < node.location) {
                p += tmp.poll();
                result++;
            }

            if(p < node.location) // 모두 충전했는데(tmp.isEmpty), 여기까지 못 오면 멈춤.
                break;

            tmp.add(node.fuel);

        } // 모든 주유소 순회 끝.

        while (!tmp.isEmpty() && p < l) {
            p += tmp.poll();
            result++;
        }

        if(p >= l)
            System.out.println(result);
        else
            System.out.println(-1);


    }

    public static class Node implements Comparable<Node> {
        int location;
        int fuel;

        public Node(int location, int fuel) {
            this.location = location;
            this.fuel = fuel;
        }

        @Override
        public int compareTo(Node o) {
            return this.location - o.location;
        }
    }
}