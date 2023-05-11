import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double C = scanner.nextDouble();

        for (int i = 0; i < C-1; i++) {
            A *= 10;
            A %= B;
        }

        A *= 10;
        A /= B;

        if(A >= 10)
            System.out.println((int)A % 10);
        else {
            System.out.println((int)A);

        }
    }
}