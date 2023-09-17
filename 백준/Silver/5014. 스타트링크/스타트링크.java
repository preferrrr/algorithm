import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] visited;
    static int f;
    static int s;
    static int g;
    static int u;
    static int d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken()); // 총 높이
        s = Integer.parseInt(st.nextToken()); // 현재 위치
        g = Integer.parseInt(st.nextToken()); // 가야할 위치
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new int[f + 1];
        Arrays.fill(visited, -1);

        if(bfs(s))
            System.out.println(visited[g]);
        else
            System.out.println("use the stairs");

    }

    static boolean bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        visited[start] = 0;
        deque.add(start);

        while(!deque.isEmpty()) {
            int poll = deque.pollFirst();

            if(poll == g)
                return true;

            if(poll - d >= 1 && visited[poll - d] == -1) {
                visited[poll-d] = visited[poll] + 1;
                deque.add(poll-d);
            }

            if(poll + u <= f && visited[poll + u] == -1) {
                visited[poll + u] = visited[poll] + 1;
                deque.add(poll + u);
            }
        }

        return false;
    }
}