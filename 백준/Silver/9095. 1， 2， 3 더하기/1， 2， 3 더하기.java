import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();



        for(int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(4);
            list.add(7);
            int test = scanner.nextInt();

            for (int j = 4; j < test; j++) {
                int data = list.get(j - 1) + list.get(j - 2) + list.get(j - 3);
                list.add(data);
            }

            if(test < 4) {
                System.out.println(list.get(test-1));
            } else {
                System.out.println(list.get(list.size()-1));

            }
        }

    }
}