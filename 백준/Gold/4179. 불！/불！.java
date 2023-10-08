import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static Deque<Node> fire = new ArrayDeque<>();
    static int[][] fireTime, jTime;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        fireTime = new int[r][c];
        jTime = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(fireTime[i], Integer.MAX_VALUE);
            Arrays.fill(jTime[i], -1);
        }

        Node start = new Node();

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = temp.charAt(j);
                if (arr[i][j] == 'J') {
                    start.x = i;
                    start.y = j;
                } else if (arr[i][j] == 'F') {
                    fire.add(new Node(i, j));
                    fireTime[i][j] = 0;
                }
            }
        }

        bfsFire();

        int result = bfsEscape(start);

        if (result < 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }


    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node() {
        }

    }

    static void bfsFire() {
        while (!fire.isEmpty()) {
            Node poll = fire.pollFirst();

            for (int i = 0; i < 4; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];

                if (x >= 0 && y >= 0 && x < r && y < c && fireTime[x][y] == Integer.MAX_VALUE && arr[x][y] != '#') {
                    fireTime[x][y] = fireTime[poll.x][poll.y] + 1;
                    fire.add(new Node(x, y));
                }
            }
        }
    }

    static int bfsEscape(Node start) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(start);
        jTime[start.x][start.y] = 0;

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];

                if (x >= 0 && y >= 0 && x < r && y < c && jTime[x][y] == -1 && arr[x][y] == '.' && jTime[poll.x][poll.y] + 1 < fireTime[x][y]) {
                    deque.add(new Node(x, y));
                    jTime[x][y] = jTime[poll.x][poll.y] + 1;
                } else if(x < 0 || y < 0 || x >= r || y >= c) {
                    return jTime[poll.x][poll.y] + 1;
                }
            }
        }

        return -1;
    }
}