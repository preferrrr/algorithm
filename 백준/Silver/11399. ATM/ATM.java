import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0 ; i < N; i++) {
            list.add(scanner.nextInt());
        }

        Collections.sort(list);
        
        int sum = 0;
        for(int i = 0 ; i < list.size(); i++) {
            int eachPerson = 0;
            for(int j = 0 ; j <= i; j++) {
                eachPerson += list.get(j);
            }
            sum += eachPerson;
        }
        System.out.println(sum);
    }
}