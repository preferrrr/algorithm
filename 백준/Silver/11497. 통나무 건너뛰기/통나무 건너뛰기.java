import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //13 10 12 11 10 11 12
        //10 10 11 11 12 12 13
        //12 11 10 10 11 12 13

        //1 2 3 4 5 6
        //2 4 5 6 7 9
        //9 7 5 2 4 6


        //2 4 5 7 9
        //2 5 9 7 4

        //1 7 8 95 100000
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] sortArr = arr.clone();

            Arrays.sort(sortArr);

            int i = 0;
            int j = n - 1;
            int k = 0;
            while (i <= j) {
                arr[i] = sortArr[k];
                if(k==n-1)
                    break;
                arr[j] = sortArr[k + 1];
                i++;
                j--;
                k += 2;
            }

            int max = 0;
            for(int a = 0 ; a < n - 1; a++) {
                int sub = Math.abs(arr[a] - arr[a+1]);
                if(max < sub)
                    max = sub;
            }

            max = max > Math.abs(arr[0] - arr[n-1]) ? max : Math.abs(arr[0] - arr[n-1]);

            sb.append(max + "\n");

        }

        System.out.print(sb);
    }
}