import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> plus = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Node> minus = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0 ; i < n; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(temp.nextToken());
            int student = Integer.parseInt(temp.nextToken());
            Node node;

            if(location - s < 0) {
                node = new Node(Math.abs(location - s), student);
                minus.add(node);
            } else {
                node = new Node(location- s, student);
                plus.add(node);
            }

        }

        int max = k;
        int result = 0;

        while(!plus.isEmpty()) {
            Node node = plus.poll();
            result += 2 * node.location; //가장 먼 곳

            if(max > node.student) {
                max -= node.student;
                while(max > 0 && !plus.isEmpty()) { // 오는 길, 태울수 있는 인원 남았어.
                    Node next = plus.poll();
                    if(max > next.student) {
                        max -= next.student;
                    } else if(max < next.student) {
                        next.student -= max;
                        plus.add(next);
                        max = 0;
                    } else {
                        max = 0;
                    }
                }
                max = k;
            } else if(max < node.student) {
                node.student -= max;
                plus.add(node);
            }


        }

        max = k;

        while(!minus.isEmpty()) {
            Node node = minus.poll();
            result += 2 * node.location; //가장 먼 곳

            if(max > node.student) { // 태울수 있는 인원 남았어.
                max -= node.student;
                while(max > 0 && !minus.isEmpty()) { // 오는 길
                    Node next = minus.poll();
                    if(max > next.student) {
                        max -= next.student;
                    } else if(max < next.student) {
                        next.student -= max;
                        minus.add(next);
                        max = 0;
                    } else {
                        max = 0;
                    }
                }
                max = k;
            } else if(max < node.student) {
                node.student -= max;
                minus.add(node);
            }


        }

        System.out.println(result);


    }

    public static class Node implements Comparable<Node> {
        int location;
        int student;

        public Node(int location, int student) {
            this.location = location;
            this.student = student;
        }

        @Override
        public int compareTo(Node o) {
            return this.location - o.location;
        }
    }
}