import java.io.*;
import java.util.*;


public class Main {
    static int n, m;
    static int[] dist = new int[101];
    static boolean[] visited = new boolean[101];
    static int[] move = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            move[a] = b;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            move[a] = b;
        }



        bfs();
        System.out.println(dist[100]);


    }

    static void bfs() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        visited[1] = true;

        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            if (poll == 100)
                break;

            for (int i = 1; i <= 6; i++) {
                int next = poll + i;
                if(next <= 100 && !visited[next]) {
                    visited[next] = true;

                    if(move[next] != 0) {
                        if(!visited[move[next]]) {
                            deque.addLast(move[next]);
                            visited[move[next]] = true;
                            dist[move[next]] = dist[poll] + 1;
                        }
                    } else {
                        deque.addLast(next);
                        dist[next] = dist[poll] + 1;
                    }
                }
            }
        }
    }


}