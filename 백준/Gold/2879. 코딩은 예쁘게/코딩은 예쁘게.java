import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int origin = Integer.parseInt(st1.nextToken());
            int goal = Integer.parseInt(st2.nextToken());
            arr[i] = goal - origin;
        }

        int result = 0;

        boolean go = false;

        boolean check = true;

        while (check) {

            check = false;

            for (int i = 0; i < n; i++) {

                if(arr[i] != 0)
                    check = true;

                if (!go && arr[i] != 0) // 연속되고 있는 중이 아니고 , 현재 0이 아니면,
                    result++;

                if (arr[i] * arr[i + 1] > 0) // 다음과 부호가 같으면,
                    go = true; // 연속되게
                else go = false; // 같지 않으면 연속되지 않게.

                if (arr[i] > 0) //현재 값이 양수면 빼주고, 음수면 더해줌.
                    arr[i]--;
                else if (arr[i] < 0)
                    arr[i]++;
            }

        }

        System.out.println(result);

    }

}
