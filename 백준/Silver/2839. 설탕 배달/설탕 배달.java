import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(br.readLine());

        int result = 0;

        while (weight > 0) {
            if (weight % 5 == 0) {
                result += weight / 5;
                break;
            } else if(weight >= 3) {
                weight -= 3;
                result++;
            } else {
                result = -1;
                break;
            }
        }

        System.out.println(result);
    }
}