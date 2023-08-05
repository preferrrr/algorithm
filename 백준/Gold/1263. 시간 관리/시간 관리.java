import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //3시간 걸리고 5시 내에 처리해야함.
        //마감시간 내에 모두 처리해야하고, 최대한 늦게 시작해야함.

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Work> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Work work = new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            queue.add(work);
        }

        Work start = queue.poll();
        int result = start.y - start.x;

        while (!queue.isEmpty()) {
            Work work = queue.poll();
            if(work.x > work.y || work.x > result) {
                result = -1;
                break;
            }
            else if(work.y < result){
                result = work.y - work.x;
            } else {
                result -= work.x;
            }
        }

        System.out.println(result);

    }

    public static class Work implements Comparable<Work> {
        int x;
        int y;

        public Work(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Work o) {
            if (o.y == this.y)
                return o.x - this.x;
            return o.y - this.y;
        }
    }

}