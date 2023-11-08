import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> queue = new PriorityQueue<>();
        for(int i = 0 ; i < n; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new Meeting(start, end));
        }

        int count = 0;
        int end = 0;
        while(!queue.isEmpty()) {
            Meeting poll = queue.poll();

            if(end <= poll.start) {
                end = poll.end;
                count++;
            }
        }

        System.out.println(count);


    }

    static class Meeting implements Comparable<Meeting> {
        int start, end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Meeting o) {
            if(this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}