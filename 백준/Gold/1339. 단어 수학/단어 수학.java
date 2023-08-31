import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //65
        int[] alp = new int[26];

        for(int i = 0 ; i < n; i++) {
            String word = br.readLine();

            for(int j = 0; j < word.length(); j++) {
                alp[word.charAt(j) - 65] += Math.pow(10, word.length() - j - 1);
            }
        }

        Arrays.sort(alp);

        int result = 0;

        int k = 9;
        for(int i = 25; i >= 16; i--, k--) {
            result += alp[i] * k;
        }

        System.out.println(result);
    }
}