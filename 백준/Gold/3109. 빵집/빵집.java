import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] arr;

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

        for (int i = 0; i < r; i++) {
            dfs(i, 0);
        }

        System.out.println(count);


    }

    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int count = 0;

    static boolean dfs(int i, int j) {
        if (j == c - 1) {
            count++;
            return true;
        }
        boolean result = false;
        for (int d = 0; d < 3; d++) {
            int x = i + dx[d];
            int y = j + dy[d];

            if (x >= 0 && y >= 0 && x < r && y < c && arr[x][y] == '.') {

                arr[x][y] = '-';

                result = dfs(x, y);

                if(result)
                    break;
            }
        }


        return result;

    }
}