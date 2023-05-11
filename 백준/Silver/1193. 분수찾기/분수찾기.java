import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();

        int i = 1;
        int count = 0;
        while (X > i) { 
            X -= i;
            i++;
            count++;
        }

        if(count % 2 == 1)
            System.out.println(X + "/" + (i - (X - 1)));
        else
            System.out.println((i - (X - 1)) + "/" + X);

    }
}