import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        //11001100

        int zero = 0;
        int one = 0;
        int cur = (int) word.charAt(0) - 48;
        if (cur == 0)
            zero++;
        else
            one++;
        for(int i = 1 ; i < word.length(); i++) {
            int temp = (int) word.charAt(i) - 48;
            if(cur != temp) {
                if(temp == 1) {
                    cur = 1;
                    one++;
                }
                else {
                    cur = 0;
                    zero++;
                }
            }
        }
        int result = zero > one ? one : zero;
        System.out.println(result);
    }
}