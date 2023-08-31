import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0)
                plus.add(num);
            else
                minus.add(num);
        }

        int result = 0;

        while (!plus.isEmpty()) {
            int a = plus.poll();
            int b;
            if (!plus.isEmpty())
                b = plus.poll();
            else b = 0;
            if(a * b > a + b)
                result += a * b;
            else result += a + b;
        }

        while(!minus.isEmpty()) {
            int a = minus.poll();
            int b;
            if(!minus.isEmpty())
                b = minus.poll();
            else {
                result += a;
                break;
            }

            result += a * b;
        }

        System.out.println(result);
    }
}