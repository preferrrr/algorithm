import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] greedy = new int[N];

        int count = 0;

        while (true) {
            if (N == 0) {
                System.out.println(count);
                break;
            } else if (N >= 5) {
                greedy[count] = 5;
                N -= 5;
                count++;
            } else if (N >= 3 && N < 5) {
                greedy[count] = 3;
                N -= 3;
                count++;
            }
            else {
                boolean temp = false;
                for(int i = count -1 ; i >= 0; i--) {
                    if(greedy[i] == 5) {
                        greedy[i] = 3;
                        N += 2;
                        temp = true;
                        break;
                    }
                }
                if(!temp) {
                    System.out.println(-1);
                    break;
                }
            }
        }

    }
}