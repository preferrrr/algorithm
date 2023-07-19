import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String word = br.readLine();

        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>();

        int result = 0;

        for(int i = 0 ; i < word.length(); i++) {
            if(word.charAt(i) == 'A')
                a.offer(i);
            else if(word.charAt(i) == 'B')
                b.offer(i);
            else if(word.charAt(i)== 'C') {
                if(!b.isEmpty() && b.peek() < i) {
                    b.poll();
                    result++;
                }
            }
        }

        while(!b.isEmpty() && !a.isEmpty()) {
            if(a.peek() < b.peek()) {
                a.poll();
                b.poll();
                result++;
            } else {
                b.poll();
            }
        }


        System.out.println(result);

    }
}