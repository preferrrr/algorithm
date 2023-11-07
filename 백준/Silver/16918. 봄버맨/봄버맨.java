import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int[][] time;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        time = new int[r][c];

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = temp.charAt(j);
                if (arr[i][j] == 'O')
                    time[i][j] = 3;
            }
        }

        int count = 1;

        while (count < n) {
            count++;

            if (count % 2 == 0) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (arr[i][j] == '.') {
                            arr[i][j] = 'O';
                            time[i][j] = count + 3;
                        }
                    }
                }
            } else {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {

                        if (arr[i][j] == 'O' && time[i][j] == count) {
                            for (int d = 0; d < 4; d++) {
                                int x = i + dx[d];
                                int y = j + dy[d];

                                if(check(x, y, count)) {
                                    arr[x][y] = '.';
                                    time[x][y] = 0;
                                }
                            }

                            arr[i][j] = '.';
                            time[i][j] = 0;
                        }
                    }
                }
            }


        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);


    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean check(int x, int y, int count) {
        return x >= 0 && y >= 0 && x < r && y < c && !(arr[x][y] == 'O' && time[x][y] == count);
    }
}