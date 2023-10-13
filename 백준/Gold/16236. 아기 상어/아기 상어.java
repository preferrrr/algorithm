import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;

    static Node cur;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    cur = new Node(i, j, 0);
                }
            }
        }

        while (true) {
            boolean help = bfs(cur);

            if(!help)
                break;
        }

        System.out.println(result);

    }

    static class Node implements Comparable<Node> {
        int x, y, w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w; //거리
        }

        @Override
        public int compareTo(Node o) {
            if (this.w == o.w) {
                if (this.x == o.x)
                    return this.y - o.y;
                return this.x - o.x;
            }
            return this.w - o.w;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int result = 0;
    static int size = 2; // 아기 상어 크기
    static int feed = 0; // 먹은 물고기 수

    static boolean bfs(Node start) {
        Deque<Node> deque = new ArrayDeque<>();

        boolean[][] visited = new boolean[n][n];
        deque.add(start);

        PriorityQueue<Node> feeds = new PriorityQueue<>();

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            if(arr[poll.x][poll.y] < size && arr[poll.x][poll.y] != 0)
                feeds.add(poll);

            for (int d = 0; d < 4; d++) {
                int x = poll.x + dx[d];
                int y = poll.y + dy[d];

                if (x >= 0 && y >= 0 && x < n && y < n
                        && !visited[x][y]
                        && arr[x][y] <= size) {
                    visited[x][y] = true;
                    deque.add(new Node(x, y, poll.w + 1));
                }
            }
        }

        //가장 가까운 물고기 한마리 먹기

        if(!feeds.isEmpty()) {
            eat(cur, feeds.peek());
            return true;
        } else {
            return false;
        }


    }

    static void eat(Node cur, Node fish) {
        //아기 상어가 먹이 위치로 이동
        arr[fish.x][fish.y] = 9;
        arr[cur.x][cur.y] = 0;

        //static 변수의 아기 상어 위치 변경
        cur.x = fish.x;
        cur.y = fish.y;

        //걸리는 시간 더해주고, 먹이 먹은 수 증가
        result += fish.w;
        feed++;

        if(feed == size) {
            size++;
            feed = 0;
        }


    }
}