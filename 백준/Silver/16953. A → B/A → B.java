import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//
//        Scanner scanner = new Scanner(System.in);
//        int start = scanner.nextInt();
//        int end = scanner.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        check(start, end);
    }

    public static int count = 0;

    public static void check(int start, int end) {
        if (end == start) {
            System.out.println(count + 1);
        } else if (end < start) {
            System.out.println(-1);
        } else {
            if (end % 10 == 1) {
                count++;
                end = end / 10;
                check(start, end);
            } else if (end % 2 == 0) {
                count++;
                check(start, end/2);
            } else {
                System.out.println(-1);
            }
        }
    }
}