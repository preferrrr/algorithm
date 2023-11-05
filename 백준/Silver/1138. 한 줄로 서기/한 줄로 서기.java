import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //1이 왼쪽에 2명있으면 => 0번째
        //2가 왼쪽에 n명 있으면

        int[] result = new int[n];

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(result[j] == 0 && arr[i] == count) {
                    result[j] = i;
                    break;
                }
                if(result[j] > i || result[j] == 0)
                    count++;

            }
        }

        for(int i = 0 ; i < n; i++) {
            System.out.print(result[i] + " ");
        }



    }

}