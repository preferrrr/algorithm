import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<String> list = new ArrayList<>();

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }
        
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else if (o1.length() < o2.length())
                    return -1;
                else {
                    return o1.compareTo(o2);
                }
            }
        };

        Collections.sort(list, comparator);

        List<String> result = new ArrayList<>();

        for (String item : list) {
            if (!result.contains(item))
                result.add(item);
        }

        for (String item : result) {

            System.out.println(item);
        }

    }
}