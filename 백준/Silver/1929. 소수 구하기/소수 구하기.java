import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            list.add(i);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 2; j <= Math.sqrt(list.get(i)); j++) {
                if (list.get(i) % j == 0){
                    list.remove(i);
                    break;
                }

            }
        }

        if(list.get(0) == 1) {
            list.remove(0);
        }


        for (Integer item : list) {
            System.out.println(item);
        }

    }
}