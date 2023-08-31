import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        for (int t = 0; t < c; t++) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Long> queue = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                queue.add(Long.parseLong(st.nextToken()));
            }

            long result = 0;
            while(queue.size() > 1) {
                Long sum = queue.poll() + queue.poll();
                result += sum;
                queue.add(sum);
            }

            sb.append(result+"\n");
        }

        System.out.println(sb);
    }
}