import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        int max = 0;
        for(int i = 0 ; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(arr[temp - 1] == 0) {
                arr[temp] += 1;
            } else {
                arr[temp] = arr[temp-1] + 1;
                if(arr[temp] > max)
                    max = arr[temp];
            }
        }

        if(max != 0) {
            System.out.println(n-max);
        }
        else {
            System.out.println(n - 1);
        }



    }
}