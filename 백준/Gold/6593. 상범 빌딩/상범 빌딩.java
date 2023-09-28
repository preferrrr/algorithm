import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); // z
            R = Integer.parseInt(st.nextToken()); // x
            C = Integer.parseInt(st.nextToken()); // y

            if (L == 0 && R == 0 && C == 0)
                break;

            arr = new char[L][R][C];
            visited = new int[L][R][C];

            Node start = new Node();

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String temp = br.readLine();
                    for (int k = 0; k < C; k++) {
                        visited[i][j][k] = -1;
                        arr[i][j][k] = temp.charAt(k);

                        if (arr[i][j][k] == 'S')
                            start = new Node(i, j, k);

                    }
                }
                br.readLine();
            }

            int result = bfs(start);

            if(result == -1) {
                sb.append("Trapped!").append("\n");
            } else {
                sb.append("Escaped in " + result + " minute(s).").append("\n");
            }


        }

        System.out.print(sb);
    }

    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static int[][][] visited;
    static char[][][] arr;

    static int L, R, C;

    static class Node {
        int x, y, z;

        public Node(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Node() {}
    }

    static int bfs(Node start) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start.z][start.x][start.y] = 0;

        while(!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            if(arr[poll.z][poll.x][poll.y] == 'E')
                return visited[poll.z][poll.x][poll.y];

            for(int i = 0 ; i < 6; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];
                int z = poll.z + dz[i];

                if(z >= 0 && z < L && x >= 0 && x < R && y >= 0 && y < C && visited[z][x][y] == -1 && (arr[z][x][y]=='.' || arr[z][x][y] == 'E')) {
                    visited[z][x][y] = visited[poll.z][poll.x][poll.y] + 1;
                    deque.addLast(new Node(z, x, y));
                }
            }
        }
        return -1;
    }
}