import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken(" "));
        }



        int[] result = new int[N];

        for(int i = 0; i < N; i++) {
            int max = 0;
            for(int j = i; j >= 0; j--) {
                if(list[i] > list[j] && result[j] > max) {
                    max = result[j];
                }
            }
            if(max == 0) {
                result[i] = 1;
            }else {
                result[i] = max + 1;
            }

        }

        Arrays.sort(result);
        System.out.println(result[result.length-1]);

    }
}