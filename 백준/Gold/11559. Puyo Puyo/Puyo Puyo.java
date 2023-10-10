import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] arr = new char[12][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 6; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }

        int result = 0;

        while (true) {
            boolean change = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (arr[i][j] != '.') {
                        boolean check = bfs(i, j);
                        if(check)
                            change = check;
                    }
                }
            }

            for (int i = 11; i >= 0; i--) {
                for (int j = 5; j >= 0; j--) {
                    if(arr[i][j] != '.')
                        poll(i, j);
                }
            }

            if (change)
                result++;
            else break;
        }

        System.out.println(result);


    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean bfs(int i, int j) {
        Deque<Node> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[12][6];

        deque.add(new Node(i, j));
        visited[i][j] = true;

        List<Node> nodes = new ArrayList<>();

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            nodes.add(poll);

            for (int d = 0; d < 4; d++) {
                int x = poll.x + dx[d];
                int y = poll.y + dy[d];

                if (x >= 0 && y >= 0 && x < 12 && y < 6 && !visited[x][y] && arr[poll.x][poll.y] == arr[x][y]) {
                    visited[x][y] = true;
                    deque.add(new Node(x, y));
                }

            }
        }

        if (nodes.size() >= 4) {
            nodes.stream().forEach(node -> arr[node.x][node.y] = '.');
            return true;
        } else return false;
    }

    static void poll(int x, int y) {
        for (int i = 11; i > x; i--) {
            if (arr[i][y] == '.') {
                arr[i][y] = arr[x][y];
                arr[x][y] = '.';
                break;
            }
        }
    }
}