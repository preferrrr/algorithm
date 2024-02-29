import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] arr;
    static int n, k, l;
    static int[] direction = new int[10001];
    static int length = 1;


    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
        }

        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();

            if (b.equals("D"))
                direction[a] = 1;
            else
                direction[a] = -1;
        }
    }

    static int solve() {

        int time = 0;

        int x = 1;
        int y = 1;
        int curD = 0;

        while (true) {

            if (curD == 0) {
                if (!checkRange(x, y + 1) || !able(x, y, x, y + 1))
                    break;
                apple(x, y + 1);
                arr[x][y + 1] = arr[x][y] + 1;
                y++;
            } else if (curD == 1) {
                if (!checkRange(x + 1, y) || !able(x, y, x + 1, y))
                    break;
                apple(x + 1, y);
                arr[x + 1][y] = arr[x][y] + 1;
                x++;
            } else if (curD == 2) {
                if (!checkRange(x, y - 1) || !able(x, y, x, y - 1))
                    break;
                apple(x, y - 1);
                arr[x][y - 1] = arr[x][y] + 1;
                y--;
            } else {
                if (!checkRange(x - 1, y) || !able(x, y, x - 1, y))
                    break;
                apple(x - 1, y);
                arr[x - 1][y] = arr[x][y] + 1;
                x--;
            }
            time++;

            if (direction[time] == 1) {
                curD = (curD + 1) % 4;

            } else if (direction[time] == -1) {
                curD = (curD + 3) % 4;

            }
        }

        return time + 1;

    }

    static boolean checkRange(int i, int j) {
        return i <= n && j <= n && i >= 1 && j >= 1;
    }

    static void apple(int i, int j) {
        if (arr[i][j] == -1) {
            length++;
            arr[i][j] = 0;
        }

    }

    static boolean able(int curI, int curJ, int i, int j) {
        return arr[i][j] == 0 || arr[curI][curJ] - length >= arr[i][j];
    }
}