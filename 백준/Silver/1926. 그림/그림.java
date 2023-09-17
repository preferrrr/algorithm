import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    count++;
                    int temp = bfs(i, j);
                    if(temp > max)
                        max = temp;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);


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

    static int bfs(int x, int y) {
        Deque<Node> deque = new ArrayDeque<>();
        arr[x][y] = -1;
        deque.add(new Node(x,y));

        int count = 0;
        while(!deque.isEmpty()) {
            Node poll = deque.pollFirst();
            count++;

            for (int i = 0; i < 4; i++) {
                int tempX = poll.x + dx[i];
                int tempY = poll.y + dy[i];

                if (tempX >= 0 && tempY >= 0 && tempX < n && tempY < m && arr[tempX][tempY] == 1) {
                    arr[tempX][tempY] = -1;
                    deque.add(new Node(tempX, tempY));
                }
            }
        }

        return count;



    }
}