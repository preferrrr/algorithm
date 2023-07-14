import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //40 30 30 50
        //40 60 50 / 60
        //60 90 / 150
        // 150 / 300

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> queue = new PriorityQueue<>();
            for (int j = 0; j < n; j++) {
                queue.add(Long.parseLong(st.nextToken()));
            }
            long result = 0;
            while (queue.size() > 1) {
                long temp = queue.poll() + queue.poll();
                result += temp;
                queue.add(temp);
            }

            sb.append(result + "\n");
        }

        System.out.print(sb);
    }
}