import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[100001];
    static int[] dist = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start] = true;

        while(!deque.isEmpty()) {
            int poll = deque.pollFirst();

            if(poll == end)
                break;

            if(poll + 1 <= 100000 && !visited[poll + 1]) {
                visited[poll + 1] = true;
                dist[poll + 1] = dist[poll] + 1;
                arr[poll + 1] = poll;
                deque.add(poll + 1);
            }

            if(poll - 1 >= 0 && !visited[poll - 1]) {
                visited[poll - 1] = true;
                dist[poll - 1] = dist[poll] + 1;
                arr[poll -1] = poll;
                deque.add(poll - 1);
            }

            if(poll * 2 <= 100000 && !visited[poll * 2]) {
                visited[poll * 2] = true;
                dist[poll * 2] = dist[poll] + 1;
                arr[poll * 2] = poll;
                deque.add(poll * 2);
            }
        }

        Stack<Integer> stack = new Stack<>();

        int temp = end;
        while(temp != start) {
            stack.add(temp);
            temp = arr[temp];
        }
        stack.add(start);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]+ "\n");
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

}