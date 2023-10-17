import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while(bfs()) {
            time++;
        }

        System.out.println(time);

    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean bfs() {
        Deque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], 0);
        }

        deque.add(new Node(0, 0));
        visited[0][0] = 1;

        List<Node> melt = new ArrayList<>();

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();


            for (int d = 0; d < 4; d++) {
                int x = poll.x + dx[d];
                int y = poll.y + dy[d];

                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (arr[x][y] == 0 && visited[x][y] == 0) {
                        visited[x][y] = 1;
                        deque.add(new Node(x, y));
                    } else if (arr[x][y] == 1) {
                        if (visited[x][y] == 0)
                            visited[x][y] = 1;
                        else if (visited[x][y] == 1) {
                            visited[x][y] = 2;
                            melt.add(new Node(x, y));
                        }
                    }
                }
            }
        }

        if (melt.size() > 0) {
            melt.stream().forEach(node -> arr[node.x][node.y] = 0);
            return true;
        } else {
            return false;
        }

    }
}