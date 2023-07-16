import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> did = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> dma = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp > 0)
                did.add(temp);
            else
                dma.add(temp);
        }

        int result = 0;

        while (!did.isEmpty()) {
            int a = did.poll();
            if (!did.isEmpty()) {
                int b = did.poll();
                if(a * b > a + b) {
                    result += a * b;
                } else {
                    result += a + b;
                }
            } else {
                result += a;
            }
        }

        while(!dma.isEmpty()) {
            int a = dma.poll();
            if(!dma.isEmpty()) {
                int b = dma.poll();
                result += a * b;
            } else {
                result += a;
            }
        }

        System.out.println(result);
        //양수일 때 곱하는데 둘 중 하나가 1이면 ?


    }
}