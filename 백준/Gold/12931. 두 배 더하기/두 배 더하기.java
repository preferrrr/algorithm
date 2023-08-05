import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int count = 0;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        while (!check(arr)) {

            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    continue;
                } else if (arr[i] % 2 != 0) {
                    result++;
                    arr[i] -= 1;
                }
            }

            boolean temp = false;
            for(int i = 0 ; i < n; i++) {
                if(arr[i] != 0) {
                    temp = true;
                    arr[i] /= 2;
                }
            }
            if(temp)
                result++;

        }


        System.out.println(result);

        //먼저 한 바퀴 돌아서 2로 안 나눠지는것들 1 뻄.
        //그 다음 모두 2로 나눠.
        //모두 2로 나누는 것을 최대한 많이 해야 함.


    }

    public static boolean check(int[] arr) {
        boolean result = true;
        for(int i = 0 ; i < arr.length; i++) {
            if(arr[i] != 0)
                result = false;
        }

        return result;
    }
}