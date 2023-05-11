import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int count = 0;

        int[] list = new int[5000];

        boolean fail = false;

        while (true) {

            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum += list[i];
            }

            if (sum == N)
                break;

            else if (sum < N) {
                if(list[0] == 0) {
                    list[count] = 5;
                    count++;
                }
                else if(list[count-1] == 3) {
                    list[count] = 3;
                    count++;
                }
                else {
                    list[count] = 5;
                    count++;
                }
            }
            else if (sum > N) {
                if(list[0] == 3) {
                    fail = true;
                    break;
                }

                for(int i = count-1; i >= 0; i--) {
                    if(list[i] == 5) {
                        list[i] = 3;
                        break;
                    }
                }

            }
        }
        if(fail)
            System.out.println(-1);
        else
            System.out.println(count);
    }
}