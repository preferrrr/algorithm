import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            arr[i] = b - a;
        }

        int result = 0;

        boolean temp = false;
        while(!check(arr)) {
            for(int i = 0 ; i < n; i++) {

                if(!temp && arr[i] != 0)
                    result++;

                if(arr[i] * arr[i+1] > 0) {
                    temp = true;
                } else {
                    temp = false;
                }

                if(arr[i] > 0)
                    arr[i]--;
                else if(arr[i] < 0)
                    arr[i]++;
            }
        }

        System.out.println(result);

    }

    public static boolean check(int[] arr) {
        for(int i = 0 ; i < arr.length; i++) {
            if(arr[i] != 0)
                return false;
        }

        return true;
    }
}