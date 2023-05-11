import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        String test = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(test);

        int num = Integer.parseInt(stringTokenizer.nextToken(" "));

        int num2;
        int count = 1;
        for (int i = 1; i < n; i++) {
            num2 = Integer.parseInt(stringTokenizer.nextToken(" "));
            if (num2 >= num)
                count++;
            num = num2;
        }

        System.out.println(count);
    }
}