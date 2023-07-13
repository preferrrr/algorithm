import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Time> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Time time = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            arr.add(time);
        }

        Collections.sort(arr);


        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(arr.get(0).y);

        for (int i = 1; i < arr.size(); i++) {
            if(queue.peek() <= arr.get(i).x) {
                queue.poll();
            }
            queue.add(arr.get(i).y);
        }

        System.out.println(queue.size());


    }

    public static class Time implements Comparable<Time> {
        int x;
        int y;

        public Time(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Time o) {
            if (this.x == o.x)
                return this.y - o.y;
            return this.x - o.x;
        }
    }
}