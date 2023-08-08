import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(node);
        }
        Collections.sort(list);

        int[] arr = new int[1002];


        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            for (int j = node.start; j <= node.end; j++) {
                arr[j] += 1;
            }
        }

        int height = 0;
        int start = 0;
        int end = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (arr[i] > height) {
                    height = arr[i];
                }
                if (start == 0) {
                    start = i;
                    end = i;
                }

                else if (start != 0)
                    end = i;
            } else {
                result += (end - start + 1) * height;
                start = 0;
                end = 0;
                height = 0;
            }

        }

        System.out.println(result);


    }

    public static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int x, int y) {
            this.start = x;
            this.end = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.start == o.start)
                return o.end - this.end;
            return this.start - o.start;
        }
    }
}