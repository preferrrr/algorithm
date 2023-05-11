import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;

        for(int i = 1; i <= N; i++) {
            if(i >= 1 && i <= 99)
                count++;
            else if(i >= 100) {
                // 100의 자리 : i / 100, 10의 자리 : (i % 100) / 10 , 1의 자리 : i % 10
                int sub1 = (i/100) - ((i % 100) / 10);
                int sub2 = ((i % 100) / 10) - (i % 10);
                if(sub1 == sub2)
                    count++;
            }
        }
        System.out.println(count);
    }
}