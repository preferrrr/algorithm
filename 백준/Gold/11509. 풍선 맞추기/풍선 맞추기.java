import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[1000002];

        int result = 0;

        for(int i = 0 ; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[temp]++;

            if(arr[temp+1] == 0) {
                result++;
            } else {
                arr[temp+1]--;
            }
        }

        System.out.println(result);



    }
}