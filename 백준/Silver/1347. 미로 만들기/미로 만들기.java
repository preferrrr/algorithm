import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String direction = br.readLine();

        char[][] arr = new char[101][101]; // 0 100 50

        for(int i = 0 ; i < 101; i++) {
            Arrays.fill(arr[i], '#');
        }

        int curX = 50;
        int curY = 50;
        arr[curX][curY] = '.';
        int curD = 1; // 0: 왼, 1: 아래, 2: 오른, 3: 위
        for (int i = 0; i < direction.length(); i++) {
            char dir = direction.charAt(i);
            if (dir == 'R' || dir == 'L')
                curD = move(curD, dir);
            else {
                if (curD == 1) {
                    curX++;
                    arr[curX][curY] = '.';
                } else if (curD == 2) {
                    curY++;
                    arr[curX][curY] = '.';
                } else if (curD == 3) {
                    curX--;
                    arr[curX][curY] = '.';
                } else {
                    curY--;
                    arr[curX][curY] = '.';
                }
            }

        }

        int minX = 101, minY = 101;
        int maxX = -1, maxY = -1;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (arr[i][j] == '.') {
                    if (i > maxX)
                        maxX = i;
                    if (i < minX)
                        minX = i;
                    if (j > maxY)
                        maxY = j;
                    if (j < minY)
                        minY = j;
                }
            }
        }


        for(int i = minX; i <= maxX; i++) {
            for(int j = minY; j <= maxY; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }


    }

    static int move(int curD, char dir) {
        if (curD == 1 && dir == 'L')
            return 2;
        else if (curD == 1 && dir == 'R')
            return 0;
        else if (curD == 2 && dir == 'L')
            return 3;
        else if (curD == 2 && dir == 'R')
            return 1;
        else if (curD == 3 && dir == 'R')
            return 2;
        else if (curD == 3 && dir == 'L')
            return 0;
        else if (curD == 0 && dir == 'L')
            return 1;
        else
            return 3;
    }
}