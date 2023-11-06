import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[19][19];

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minX = -1, minY = -1, result = -1;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if ((arr[i][j] == 1 || arr[i][j] == 2)) {

                    for (int d = 0; d < 4; d++) {

                        int count = 1;
                        for (int k = 1; ; k++) {
                            int x = i + dx[d] * k;
                            int y = j + dy[d] * k;

                            if (!check(x, y, arr[i][j]))
                                break;

                            count++;
                        }



                        if (count == 5 && !check(i - dx[d], j - dy[d], arr[i][j])) {
                            result = arr[i][j];

                            if (d >= 0 && d <= 2) {
                                minY = j;
                                minX = i;
                            } else {
                                minY = j - 4;
                                minX = i + 4;
                            }

                            break;
                        }

                    }

                    if (result != -1)
                        break;
                }
            }


        }

        if (result == -1)
            System.out.println(0);
        else {
            minX++;
            minY++;
            System.out.println(result);
            System.out.println(minX + " " + minY);
        }
    }

    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, 1, 0, -1};

    static boolean check(int x, int y, int color) {
        return x >= 0 && y >= 0 && x < 19 && y < 19 && arr[x][y] == color;
    }


}