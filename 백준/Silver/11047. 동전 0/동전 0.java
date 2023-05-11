import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }

        int sum = 0;
        int count = 0;
        int index = list.size() - 1;
        while (sum != K) {
            if (sum == K)
                break;
            else if (sum < K) {
                sum += list.get(index);
                count++;
            } else if (sum > K) {
                sum -=list.get(index);
                count--;
                index--;
            }
        }

        System.out.println(count);


    }
}