import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = temp.charAt(j);
            }
        }

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'X') {
                    if (check(i, j))
                        list.add(new Node(i, j));
                }
            }
        }

        list.stream().forEach(node -> arr[node.x][node.y] = '.');


        int maxX = 0, maxY = 0;
        int minX = 11, minY = 11;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'X') {
                    if (j < minY)
                        minY = j;
                    if (j > maxY)
                        maxY = j;
                    if (i < minX)
                        minX = i;
                    if (i > maxX)
                        maxX = i;
                }
            }
        }

        for(int i = minX; i <= maxX; i++) {
            for(int j = minY; j <= maxY; j++)
                System.out.print(arr[i][j]);
            System.out.println();
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
    }

    static boolean check(int i, int j) {
        int count = 0;
        for (int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];
            if (x >= 0 && y >= 0 && x < r && y < c && arr[x][y] == '.')
                count++;
            else if (x < 0 || y < 0 || x >= r || y >= c)
                count++;
        }

        if (count >= 3)
            return true;
        else return false;
    }
}