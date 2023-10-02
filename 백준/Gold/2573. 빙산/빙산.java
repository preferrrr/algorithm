import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        while(true) {

            int linked = 0;

            for(int i = 0 ; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    if(arr[i][j] != 0 && !visited[i][j]) {
                        linked++;
                        bfs(i, j);
                    }
                }
            }

            if(linked == 0) {
                result = 0;
                break;
            }
            else if(linked == 1) {
                visited = new boolean[r][c];
                result++;
            } else {
                break;
            }

        }

        System.out.println(result);
    }

    static class Node {
        int x, y, w;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int i, int j) {
        Deque<Node> deque = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();

        deque.add(new Node(i, j));
        visited[i][j] = true;

        while(!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            int zero = 0;

            for(int d = 0 ; d < 4; d++) {
                int x = poll.x + dx[d];
                int y = poll.y + dy[d];

                if(rangeCheck(x, y) && arr[x][y] == 0) {
                    zero++;
                }
            }
            
            list.add(new Node(poll.x, poll.y, zero));

            for(int d = 0; d < 4; d++) {
                int x = poll.x + dx[d];
                int y = poll.y + dy[d];
                if(rangeCheck(x, y) && !visited[x][y] && arr[x][y] != 0) {
                    visited[x][y] = true;
                    deque.addLast(new Node(x,y));
                }
            }
        }

        meltIceburg(list);

    }

    static void meltIceburg(List<Node> list) {
        for(Node node : list) {
            if(arr[node.x][node.y] > node.w)
                arr[node.x][node.y] -= node.w;
            else arr[node.x][node.y] = 0;
        }
    }

    static boolean rangeCheck(int x, int y) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }
}