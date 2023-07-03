import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i = 0 ; i < N; i++) {
            int state = 0;
            for(int j = 0 ; j < M; j++) {
                if((array[i][j] == 1 || array[i][j] == 2) && state == 0) { // 1,2아니고 state 0이면 칠해 count++
                    state = array[i][j];
                    count++;
                }
                else if(array[i][j] == 0) { // 0이면 state 0으로
                    state = 0;
                }
                else if(array[i][j] != state && array[i][j] != array[i][j-1]) { // 이전칸이랑 색깔이 같으면 count 해주지 않음
                    count++; // 이전 칸이랑 색깔이 달라며 한번 덧칠 해주는 것.
                }
            }
        }

        System.out.println(count);

    }
}