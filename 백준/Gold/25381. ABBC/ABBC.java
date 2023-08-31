import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        PriorityQueue<Integer> A = new PriorityQueue<>();
        PriorityQueue<Integer> B = new PriorityQueue<>();

        int result = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'A')
                A.add(i);
            else if (word.charAt(i) == 'B')
                B.add(i);
            else {
                if(!B.isEmpty() && B.peek() < i) {
                    result++;
                    B.poll();
                }
            }

        }

        while(!A.isEmpty() && !B.isEmpty()) {
            if(A.peek() < B.peek()) {
                result++;
                A.poll();
                B.poll();
            } else B.poll();
        }

        System.out.println(result);


    }
}