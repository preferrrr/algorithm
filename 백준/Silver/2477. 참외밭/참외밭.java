import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int east = 0, west = 0, north = 0, south = 0;

        int[][] arr = new int[2][6];
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[0][i] = a;
            arr[1][i] = b;

            if (a == 1) {
                east += b;
            } else if (a == 2)
                west += b;
            else if (a == 3)
                south += b;
            else
                north += b;
        }

        int sub = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[0][i] == arr[0][i + 2] && arr[0][i+1] == arr[0][i+3]) {
                sub += arr[1][i+1] * arr[1][i+2];
            }
        }
        //0 2 1 3
        //1 3 2 4
        //2 4 3 5

        if(arr[0][3] == arr[0][5] && arr[0][4] == arr[0][0])
            sub += arr[1][5] * arr[1][4];
        if(arr[0][4] == arr[0][0] && arr[0][5] == arr[0][1])
            sub += arr[1][0] * arr[1][5];
        if(arr[0][5] == arr[0][1] && arr[0][0] == arr[0][2])
            sub += arr[1][1] * arr[1][0];




        System.out.println((east * south - sub) * n);

    }
}