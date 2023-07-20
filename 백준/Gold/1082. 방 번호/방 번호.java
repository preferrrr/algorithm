import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class number{
    int num, price;
    number(int num, int price) {this.num = num; this.price = price;}
}

public class Main {
    private static int N, pocket;
    private static int res[] = new int[100];
    private static number arr[];
    private static Map<Integer, Integer> m = new HashMap<>(); 

    public static void main(String[ ] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); arr = new number[N];
        for(int i = 0; i < N; i++) {
            arr[i] = new number(i, sc.nextInt());
            m.put(i, arr[i].price);
        }
        pocket = sc.nextInt();

        Arrays.sort(arr, new Comparator<number>() { 
            @Override
            public int compare(number o1, number o2) {
                if(o1.price == o2.price) return o1.num - o2.num;
                return o1.price - o2.price;
            }

        });

        int cnt = 0;
        if(arr[0].num == 0) { 
            if(N == 1 || arr[1].price > pocket) { 
                System.out.println(0); 
                System.exit(0);
            }
            res[cnt++] = arr[1].num; 
            pocket -= arr[1].price;
        }

        while(pocket - arr[0].price >= 0) {
            res[cnt++] = arr[0].num;
            pocket -= arr[0].price;
        }

        for(int i = 0; i < cnt; i++) {
            for(int j = N - 1; j >= 0; j--) { 
                if(i == 0 && j == 0) continue; 
                int tmp = pocket + m.get(res[i]) - m.get(j);
                if(tmp >= 0) {
                    pocket = tmp; 
                    res[i] = j;
                    break;
                }
            }
        }

        for(int i = 0; i < cnt; i++) System.out.print(res[i]);
    }
}