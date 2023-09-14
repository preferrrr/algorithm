import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(a);

        while(!deque.isEmpty()) {
            int poll = deque.pollFirst();

            if(poll == b)
                break;

            if(poll != 0 && poll * 2 <= 100000 && visited[poll * 2] == 0) {
                visited[poll * 2] = visited[poll] + 1;
                deque.add(poll * 2);
            }

            if(poll + 1 <= 100000 && visited[poll + 1] == 0) {
                visited[poll + 1] = visited[poll] + 1;
                deque.add(poll + 1);
            }

            if(poll - 1 >= 0 && visited[poll - 1] == 0) {
                visited[poll - 1] = visited[poll] + 1;
                deque.add(poll - 1);
            }
        }

        System.out.println(visited[b]);

    }


}