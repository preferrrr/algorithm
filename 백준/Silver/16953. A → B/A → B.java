import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();

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