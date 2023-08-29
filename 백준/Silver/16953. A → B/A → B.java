import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);

        int result = 1;

        while (true) {
            if(a == b)
                break;
            else if(a > b) {
                result = -1;
                break;
            }
            
            if (b % 10 == 1) {
                b -= 1;
                b /= 10;
                result++;
            } else if (b % 2 == 0) {
                b /= 2;
                result++;
            } else {
                result = -1;
                break;
            }
        }

        System.out.println(result);
    }
}