import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int[] stick = new int[10];
        stick[0] = 64;
        int count = 0;
        
        while (true) {
            count++;

            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum += stick[i];
            }

            if(X < sum) {
                stick[count] = 0;
                count--;
            }

            if (X == sum) {
                break;
            }

            stick[count] /= 2;
            stick[count+1] = stick[count];

        }

        System.out.println(count);
    }
}