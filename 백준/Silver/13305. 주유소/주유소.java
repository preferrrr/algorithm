import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        //더 작은 도시까지의 거리만큼 주유해야함.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dis = new int[n];
        int[] city = new int[n];

        String[] temp = br.readLine().split(" ");
        for(int i = 0 ; i < temp.length; i++) {
            dis[i] = Integer.parseInt(temp[i]);
        }

        temp = br.readLine().split(" ");
        for(int i = 0 ; i < temp.length; i++) {
            city[i] = Integer.parseInt(temp[i]);
        }

        int price = 0;
        int cur = 0;
        
        while(true) {
            if (cur == n-1) {
                System.out.println(price);
                break;
            }

            int goal = n-1;
            
            for(int i = cur ; i < n-1; i++) {
                if(city[cur] > city[i]) {
                    goal = i;
                    break;
                }
            }

            int a = 0;
            for(int i = cur; i < goal; i++) {
                a += dis[i];
            }
            price += a * city[cur];
            cur = goal;
            
        }
        
    }
}