import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int T = scanner.nextInt();

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();

        hashMap.put(1, new ArrayList<Integer>());
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < T; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if(!hashMap.containsKey(a)) {
                ArrayList<Integer> values = new ArrayList<>();
                values.add(b);
                hashMap.put(a,values);
            }
            else {
                hashMap.get(a).add(b);
            }

            if(!hashMap.containsKey(b)) {
                ArrayList<Integer> values = new ArrayList<>();
                values.add(a);
                hashMap.put(b,values);
            }
            else {
                hashMap.get(b).add(a);
            }
        }

        count(list,hashMap,1);

        System.out.println(list.size()-1);
    }

    public static void count(List<Integer> list, HashMap<Integer, ArrayList<Integer>> hashMap,int N) {
        if(list.contains(N))
            return;
        else {
            list.add(N);
            for(int i = 0 ; i < hashMap.get(N).size(); i++) {
                if(!list.contains(hashMap.get(N).get(i)) || hashMap.get(N).get(i) != 1) {
                    count(list, hashMap, hashMap.get(N).get(i));
                }

            }
        }

    }

}