import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        HashMap<Integer,ArrayList<Integer>> hashMap = new HashMap<>();


        for (int i = 0; i < N; i++) {
            int data = scanner.nextInt();
            if(!hashMap.containsKey(data)) {
                ArrayList<Integer> value = new ArrayList<>();
                value.add(data);
                hashMap.put(data, value);
            } else {
                hashMap.get(data).add(data);
            }
        }

        int M = scanner.nextInt();

        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            list2.add(scanner.nextInt());
        }

        for (int i = 0; i < M; i++) {
            if (hashMap.containsKey(list2.get(i))) {
                if (hashMap.get(list2.get(i)).contains(list2.get(i)))
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            else
                System.out.println(0);
        }
    }

}