import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp > 0) {
                plus.add(temp);
            } else {
                minus.add(temp);
            }
        }

        int max;
        if(minus.isEmpty())
            max  = plus.peek();
         else if(plus.isEmpty())
            max = Math.abs(minus.peek());
        else max = Math.max(Math.abs(minus.peek()), plus.peek());

        int result = -max;

        while (!minus.isEmpty()) {
            result += 2 * Math.abs(minus.poll());
            for (int i = 0; i < m - 1; i++) {
                if (!minus.isEmpty())
                    minus.poll();
            }
        }

        while (!plus.isEmpty()) {
            result += 2 * plus.poll();
            for (int i = 0; i < m - 1; i++) {
                if (!plus.isEmpty())
                    plus.poll();
            }
        }

        System.out.println(result);


    }
}